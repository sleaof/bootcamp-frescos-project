package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.service.IProductWarehousesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductWarehousesServiceImpl implements IProductWarehousesService {

    private BatchRepository batchRepository;

    public ProductWarehousesServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public List<Batch> productIdFromWarehouses(Long productId) {
        List<Batch> productsId = batchRepository.findAll().stream()
                .filter(p -> p.getProduct().getProductId())
                .collect(Collectors.toList());
       // ProductsWarehousesResponseDTO productsWarehousesResponseDTO = new ProductsWarehousesResponseDTO(productsId,);
        return productsId;
    }

}
