package com.mercadolibre.dambetan01.service.crud.impl;

import com.mercadolibre.dambetan01.dtos.*;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.dtos.response.TotalPriceResponseDTO;
import com.mercadolibre.dambetan01.mapper.BatchMapper;
import com.mercadolibre.dambetan01.model.*;

import com.mercadolibre.dambetan01.repository.BatchHasPurchaseOrderRepository;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.repository.PurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.crud.IBatchHasPurchaseOrder;
import com.mercadolibre.dambetan01.service.crud.IBatchService;
import com.mercadolibre.dambetan01.service.crud.IPurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

    private PurchaseOrderRepository purchaseOrderRepository;
    private ProductRepository productRepository;
    private IBatchHasPurchaseOrder batchHasPurchaseOrder;
    private IBatchService batchService;

    private ModelMapper modelMapper;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository, ProductRepository productRepository, IBatchHasPurchaseOrder batchHasPurchaseOrder, IBatchService batchService, ModelMapper modelMapper) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.productRepository = productRepository;
        this.batchHasPurchaseOrder = batchHasPurchaseOrder;
        this.batchService = batchService;
        this.modelMapper = modelMapper;
    }

    @Override
    public PurchaseOrderDTO create(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrder purchaseOrder = modelMapper.map(purchaseOrderDTO, PurchaseOrder.class);
        purchaseOrderRepository.save(purchaseOrder);

        for(ProductBatchOrderDTO productBO : purchaseOrderDTO.getProducts()) {
            Product product = productRepository.findById(productBO.getProductId()).orElseThrow();

            for(BatchDTO batch : batchService.findAll()) {
                if (batch.getProductId().equals(product.getProductId())) {
                    if(batch.getCurrentQuantity() >= productBO.getQuantity()) {
                        batchHasPurchaseOrder.create(new BatchHasPurchaseOrderDTO(null, productBO.getQuantity(), purchaseOrder.getPurchaseOrderId(), batch.getBatchNumber()));
                        batch.setCurrentQuantity(batch.getCurrentQuantity()-productBO.getQuantity());
                        batchService.update(batch);
                    }
                }
            }
        }
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
        if (!opt.isPresent()) {
            throw new NoSuchElementException("There is no Purchase Order with this Id: " + id);
        }
        purchaseOrderRepository.deleteById(id);
    }

    @Override
    public PurchaseOrderDTO findById(Long id) {
        Optional<PurchaseOrder> opt = purchaseOrderRepository.findById(id);

        if (!opt.isPresent()) {
            throw new NoSuchElementException("There is no Purchase Order with this Id: " + id);
        }
        return modelMapper.map(opt.get(), PurchaseOrderDTO.class);
    }

    @Override
    public List<PurchaseOrderDTO> findAll() {
        List<PurchaseOrderDTO> purchaseOrderDTO = purchaseOrderRepository.findAll()
                .stream()
                .map(purchaseOrder -> modelMapper.map(purchaseOrder, PurchaseOrderDTO.class))
                .collect(Collectors.toList());
        return purchaseOrderDTO;
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
        Double totalValue = 0.0;

        for(ProductBatchOrderDTO x : purchaseOrderDTO.getProducts()) {
            Optional<Product> product = productRepository.findById(x.getProductId());

            if (product.isEmpty()) {
                throw new NoSuchElementException("There is no Product with this Id: " + x.getProductId());
            }

            Float price = product.get().getPrice();
            totalValue += x.getQuantity() * price;
        }

        return new TotalPriceResponseDTO(totalValue);
    }
}
