package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import com.mercadolibre.dambetan01.service.ProductService;
import com.mercadolibre.dambetan01.service.impl.ProductWarehousesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/v1")
@RestController
public class ProductsWarehouseController {

    private ProductWarehousesServiceImpl productWarehousesService;
    private ProductService productService;

    public ProductsWarehouseController(ProductWarehousesServiceImpl productWarehousesService,ProductService productService) {
        this.productWarehousesService = productWarehousesService;
        this.productService = productService;
    }

    @GetMapping("/fresh-products/warehouse/")
    public ResponseEntity<ProductsWarehousesResponseDTO> productIdFromWarehouses(@RequestParam Long productId) throws Throwable {

        return productWarehousesService.productIdFromWarehouses(productId);

    }
}
