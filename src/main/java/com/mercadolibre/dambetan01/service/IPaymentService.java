package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.model.Payment;
import org.springframework.http.ResponseEntity;

public interface IPaymentService {
    ResponseEntity<Payment> PayPurchaseOrder(Long purchaseOrderId);
}
