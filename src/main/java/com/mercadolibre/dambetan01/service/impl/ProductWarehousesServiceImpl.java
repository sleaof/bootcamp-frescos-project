package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.service.IProductWarehousesService;
import com.mercadolibre.dambetan01.service.ProductService;
import org.json.simple.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductWarehousesServiceImpl implements IProductWarehousesService {

    private BatchRepository batchRepository;
    private ProductService productService;
    private ProductRepository productRepository;

    public ProductWarehousesServiceImpl(BatchRepository batchRepository, ProductService productService, ProductRepository productRepository) {
        this.batchRepository = batchRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductsWarehousesResponseDTO> productIdFromWarehouses(Long productId) throws Throwable {

        productService.findById(productId);
        List<JSONObject> json = batchRepository.productIdFromWarehouses(productId);
        ProductsWarehousesResponseDTO pj = new ProductsWarehousesResponseDTO(productId,json);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pj);

    }
}
