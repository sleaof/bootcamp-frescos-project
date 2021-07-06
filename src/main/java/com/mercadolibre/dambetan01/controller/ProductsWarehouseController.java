package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.service.impl.ProductWarehousesServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/api/v1")
@RestController
public class ProductsWarehouseController {

    private ProductWarehousesServiceImpl productWarehousesService;

    public ProductsWarehouseController(ProductWarehousesServiceImpl productWarehousesService) {
        this.productWarehousesService = productWarehousesService;
    }

    @GetMapping("/fresh-products/warehouse/")
    public List<Batch> productIdFromWarehouses(@RequestParam Long productId){
        return productWarehousesService.productIdFromWarehouses(productId);
    }

}
