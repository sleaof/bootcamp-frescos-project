package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.service.crud.IProductService;
import com.mercadolibre.dambetan01.service.crud.impl.ProductServiceImpl;
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
    public List<ProductDTO> selectedAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/fresh-products/list")
    public List<ProductDTO> selectedAllProductsByCategory(@RequestParam("category") String category){
        return productService.findByCategory(category);
    }
}
