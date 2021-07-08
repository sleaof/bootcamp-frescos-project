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
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        Optional<PurchaseOrder> opt = purchaseOrderRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("There is no Purchase Order with this Id: " + id);
        }
        purchaseOrderRepository.deleteById(id);
    }

    @Override
    public PurchaseOrderDTO findById(Long id) {
        Optional<PurchaseOrder> opt = purchaseOrderRepository.findById(id);

        if (opt.isEmpty()) {
            throw new NotFoundException("There is no Purchase Order with this Id: " + id);
        }
        return modelMapper.map(opt.get(), PurchaseOrderDTO.class);
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

        List<Product> products = getValidProducts(purchaseOrderDTO);

        for(ProductBatchOrderDTO x : purchaseOrderDTO.getProducts()) {
            Product product = productRepository.findById(x.getProductId()).orElseThrow(() -> new NotFoundException("There is no Product with this Id: " + x.getProductId()));

            if(products.contains(product)) {
                Float price = product.getPrice();
                totalValue += x.getQuantity() * price;
            }
        }

        return new TotalPriceResponseDTO(totalValue);
    }

    public void isValid(PurchaseOrderDTO purchaseOrderDTO) {
        buyerRepository.findById(purchaseOrderDTO.getBuyer()).orElseThrow(() -> new NotFoundException("There is no Buyer with this Id: " + purchaseOrderDTO.getBuyer()));

        for (ProductBatchOrderDTO productBO : purchaseOrderDTO.getProducts()) {
            for(BatchDTO batch : batchService.findAll()) {
                if (batch.getProductId().equals(productBO.getProductId())) {
                    if(batch.getCurrentQuantity() < productBO.getQuantity())
                        throw new NotFoundException("The quantity of the product must be lower than the quantity on stock.");
                }
            }
        }
    }

    public List<Product> getValidProducts(PurchaseOrderDTO purchaseOrderDTO) {
        List<Product> products = new ArrayList<>();
        for (ProductBatchOrderDTO productBO : purchaseOrderDTO.getProducts()) {
            Product product = productRepository.findById(productBO.getProductId()).orElseThrow(() -> new NotFoundException("There is no Product with this Id: " + productBO.getProductId()));
            if (product.getValidated().isAfter(LocalDate.now().plusDays(21))) {
                products.add(product);
            }
        }

        if(products.isEmpty())
            throw new NotFoundException("No valid products found.");

        return products;
    }

    public void addProducts(PurchaseOrderDTO purchaseOrderDTO, PurchaseOrder purchaseOrder) {
        List<Product> products = getValidProducts(purchaseOrderDTO);
        for(ProductBatchOrderDTO productBO : purchaseOrderDTO.getProducts()) {
            Product product = productRepository.findById(productBO.getProductId()).orElseThrow(() -> new NotFoundException("There is no Product with this Id: " + productBO.getProductId()));

            if(products.contains(product)){
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
}
