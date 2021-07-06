package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.PurchaseOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.model.PurchaseOrder;
import com.mercadolibre.dambetan01.service.crud.IPurchaseOrderService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RequestMapping(path = "/api/v1")
@RestController
public class PurchaseOrderController {

    private IPurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(IPurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping("/fresh-products/orders/")
    public List<ProductResponseDTO> selectedProductsFromOrderId(@RequestParam("orderId") Long orderId){
        return purchaseOrderService.selectProductsFromOrderId(orderId);
    }

    @PostMapping("/fresh-products/orders/")
    public Float createOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO){


        // purchaseOrderService.create(purchaseOrderDTO);
        return 0F;
    }

    @PutMapping("/fresh-products/orders")
    public String updateProductsById(@RequestParam("orderId") Long orderId, @RequestBody PurchaseOrder purchaseOrder){
        return "Deu bom5";
    }

}
