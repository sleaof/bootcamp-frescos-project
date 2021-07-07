package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.service.crud.IProductService;
import com.mercadolibre.dambetan01.service.crud.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/api/v1")
@RestController
public class ProductController {

    private IProductService productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/fresh-products/")
    public ResponseEntity<List<ProductDTO>> selectedAllProducts() {
        if (productService.findAll().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/fresh-products/list")
    public ResponseEntity<List<ProductDTO>> selectedAllProductsByCategory(@RequestParam("category") String category) {
        if (productService.findByCategory(category).isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productService.findByCategory(category), HttpStatus.OK);
    }
}
