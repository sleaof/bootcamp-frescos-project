package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.model.PurchaseOrder;
import com.mercadolibre.dambetan01.repository.PurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.crud.IPurchaseOrderService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1")
@RestController
public class PurchaseOrderController {

    private IPurchaseOrderService iPurchaseOrderService;

    public PurchaseOrderController(IPurchaseOrderService iPurchaseOrderService) {
        this.iPurchaseOrderService = iPurchaseOrderService;
    }

    @GetMapping("/fresh-products/")
    public String selectedAllProducts(){ return "Deu bom"; }

    @GetMapping("/fresh-products/list")
    public String selectedAllProductsByCategory(@RequestParam("category") String category){
        return "Deu bom2";
    }

    @GetMapping("/fresh-products/orders/")
    public List<JSONObject> selectedProductsFromOrderId(@RequestParam("orderId") Long orderId){
        return iPurchaseOrderService.selectProductsFromOrderId(orderId);
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
