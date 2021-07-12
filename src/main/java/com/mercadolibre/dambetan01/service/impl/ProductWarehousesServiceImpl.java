package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.service.IProductWarehousesService;
import com.mercadolibre.dambetan01.service.ProductService;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductWarehousesServiceImpl implements IProductWarehousesService {

    private BatchRepository batchRepository;
    private ProductService productService;

    public ProductWarehousesServiceImpl(BatchRepository batchRepository, ProductService productService) {
        this.batchRepository = batchRepository;
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductsWarehousesResponseDTO> productIdFromWarehouses(Long productId) throws Throwable {
        Product p = productService.findById(productId);
        List<JSONObject> json = batchRepository.productIdFromWarehouses(productId);
        ProductsWarehousesResponseDTO pj = new ProductsWarehousesResponseDTO(productId,json);
        if (p != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(pj);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
