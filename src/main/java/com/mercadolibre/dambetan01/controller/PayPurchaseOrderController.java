package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.model.Payment;
import com.mercadolibre.dambetan01.service.impl.PayPurchaseOrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping(path = "/api/v1")
@RestController
public class PayPurchaseOrderController {

    private PayPurchaseOrderServiceImpl purchaseOrderService;

    @PutMapping("/pay/purchaseOrder")
    public ResponseEntity<Payment> PayPurchaseOrder(@Param("purchaseOrderId") Long purchaseOrderId) {
        return purchaseOrderService.PayPurchaseOrder(purchaseOrderId);
    }
}
