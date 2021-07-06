package com.mercadolibre.dambetan01.service.crud.impl;

import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.dtos.PurchaseOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.model.PurchaseOrder;

import com.mercadolibre.dambetan01.repository.PurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.crud.IPurchaseOrderService;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

    private PurchaseOrderRepository purchaseOrderRepository;

    private ModelMapper modelMapper;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository, ModelMapper modelMapper) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PurchaseOrderDTO create(PurchaseOrderDTO purchaseOrderDTO) {
        //checar estoque
        //diminuir estoque


        PurchaseOrder purchaseOrder = modelMapper.map(purchaseOrderDTO, PurchaseOrder.class);
        purchaseOrderRepository.save(purchaseOrder);
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
    public List<JSONObject> selectProductsFromOrderId(Long id) {
        return purchaseOrderRepository.findProductsFromOrderById(id);
    }

    @Override
    public Float calcTotalValue(List<ProductDTO> products) {
        Double totalValue = 0.0;
        for(ProductDTO x : products) {
            //totalValue = x.getQuantity();
        }
        return null;
    }
}
