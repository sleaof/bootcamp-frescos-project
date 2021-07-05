package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.model.PurchaseOrder;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/v1")
@RestController
public class PurchaseOrderController {

    @GetMapping("/fresh-products/")
    public String selectedAllProducts(){
        return "Deu bom";
    }

    @GetMapping("/fresh-products/list")
    public String selectedAllProductsByCategory(@RequestParam("category") String category){
        return "Deu bom2";
    }

    @GetMapping("/fresh-products/orders/")
    public String selectedProductsFromOrder(@RequestParam("orderId") Long orderId){
        return "Deu bom3";
    }

    @PostMapping("/fresh-products/orders/")
    public String createOrder(@RequestBody PurchaseOrder purchaseOrder){
        return "Deu bom4";
    }

    @PutMapping("/fresh-products/orders")
    public String updateProductsById(@RequestParam("orderId") Long orderId, @RequestBody PurchaseOrder purchaseOrder){
        return "Deu bom5";
    }


}
