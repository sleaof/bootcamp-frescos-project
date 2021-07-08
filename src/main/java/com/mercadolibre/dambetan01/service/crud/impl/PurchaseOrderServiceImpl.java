package com.mercadolibre.dambetan01.service.crud.impl;

import com.mercadolibre.dambetan01.dtos.*;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.dtos.response.TotalPriceResponseDTO;

import com.mercadolibre.dambetan01.exceptions.NotFoundException;
import com.mercadolibre.dambetan01.model.*;

import com.mercadolibre.dambetan01.repository.BuyerRepository;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.repository.PurchaseOrderRepository;

import com.mercadolibre.dambetan01.service.crud.IBatchHasPurchaseOrder;
import com.mercadolibre.dambetan01.service.crud.IBatchService;
import com.mercadolibre.dambetan01.service.crud.IPurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final ProductRepository productRepository;
    private final IBatchHasPurchaseOrder batchHasPurchaseOrder;
    private final IBatchService batchService;
    private final BuyerRepository buyerRepository;

    private final ModelMapper modelMapper;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository,
                                    ProductRepository productRepository,
                                    IBatchHasPurchaseOrder batchHasPurchaseOrder,
                                    IBatchService batchService,
                                    BuyerRepository buyerRepository,
                                    ModelMapper modelMapper) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.productRepository = productRepository;
        this.batchHasPurchaseOrder = batchHasPurchaseOrder;
        this.batchService = batchService;
        this.buyerRepository = buyerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PurchaseOrderDTO create(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = modelMapper.map(purchaseOrderDTO, PurchaseOrder.class);

        isValid(purchaseOrderDTO);
        purchaseOrderRepository.save(purchaseOrder);
        addProducts(purchaseOrderDTO, purchaseOrder);

        return purchaseOrderDTO;
    }

    @Override
    public PurchaseOrderDTO update(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = modelMapper.map(purchaseOrderDTO, PurchaseOrder.class);
        purchaseOrderRepository.save(purchaseOrder);

        return purchaseOrderDTO;
    }

    @Override
    public void delete(Long id) {
        purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi encontrada nenhuma ordem de compra com este Id: " + id));

        purchaseOrderRepository.deleteById(id);
    }

    @Override
    public PurchaseOrderDTO findById(Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi encontrada nenhuma ordem de compra com este Id: " + id));

        return modelMapper.map(purchaseOrder, PurchaseOrderDTO.class);
    }

    @Override
    public List<PurchaseOrderDTO> findAll() {
        return purchaseOrderRepository.findAll()
                .stream()
                .map(purchaseOrder -> modelMapper.map(purchaseOrder, PurchaseOrderDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> findProductsByOrderId(Long id) {
        return purchaseOrderRepository.findProductsFromOrderById(id)
                .stream()
                .map(product -> modelMapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TotalPriceResponseDTO calcTotalValue(PurchaseOrderDTO purchaseOrderDTO) {
        double totalValue = 0.0;

        for(ProductBatchOrderDTO productBatchOrderDTO : getValidProducts(purchaseOrderDTO).getProducts()) {
            Product product = productRepository.findById(productBatchOrderDTO.getProductId())
                    .orElseThrow(() -> new NotFoundException("Não foi encontrado nenhum Produto com este Id: " + productBatchOrderDTO.getProductId()));

            totalValue += productBatchOrderDTO.getQuantity() * product.getPrice();
        }

        return new TotalPriceResponseDTO(totalValue);
    }

    public void isValid(PurchaseOrderDTO purchaseOrderDTO) {
        buyerRepository.findById(purchaseOrderDTO.getBuyer()).orElseThrow(() -> new NotFoundException("Não foi encontrado nenhum Comprador com este Id: " + purchaseOrderDTO.getBuyer()));

        for (ProductBatchOrderDTO productBO : purchaseOrderDTO.getProducts()) {
            for(BatchDTO batch : batchService.findAll()) {
                if (batch.getProductId().equals(productBO.getProductId())) {
                    if(batch.getCurrentQuantity() < productBO.getQuantity())
                        throw new NotFoundException("A quantidade do Produto deve ser menor do que a quantidade no estoque.");
                }
            }
        }
    }

    public PurchaseOrderDTO getValidProducts(PurchaseOrderDTO purchaseOrderDTO) {
        List<ProductBatchOrderDTO> productsBO = new ArrayList<>();
        for (ProductBatchOrderDTO productBO : purchaseOrderDTO.getProducts()) {
            Product product = productRepository.findById(productBO.getProductId())
                    .orElseThrow(() -> new NotFoundException("Não foi encontrado nenhum Produto com este Id: " + productBO.getProductId()));
            if (!product.getValidated().isAfter(LocalDate.now().plusDays(21))) {
                productsBO.add(productBO);
            }
        }
        purchaseOrderDTO.getProducts().removeAll(productsBO);

        return purchaseOrderDTO;
    }

    public void addProducts(PurchaseOrderDTO purchaseOrderDTO, PurchaseOrder purchaseOrder) {
        for(ProductBatchOrderDTO productBO : getValidProducts(purchaseOrderDTO).getProducts()) {
            Product product = productRepository.findById(productBO.getProductId())
                    .orElseThrow(() -> new NotFoundException("There is no Product with this Id: " + productBO.getProductId()));

            for(BatchDTO batch : batchService.findAll()) {
                if (batch.getProductId().equals(product.getProductId())) {
                    if(batch.getCurrentQuantity() >= productBO.getQuantity()) {
                        batchHasPurchaseOrder.create(new BatchHasPurchaseOrderDTO(null, productBO.getQuantity(), purchaseOrder.getPurchaseOrderId(), batch.getBatchNumber()));
                        batch.setCurrentQuantity(batch.getCurrentQuantity() - productBO.getQuantity());
                        batchService.update(batch);
                    } else {
                        throw new NotFoundException("The quantity of the product must be lower than the quantity on stock.");
                    }
                }
            }
        }
    }
}
