package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.enums.OrderStatus;
import com.mercadolibre.dambetan01.exceptions.NotFoundException;
import com.mercadolibre.dambetan01.model.Payment;
import com.mercadolibre.dambetan01.model.PurchaseOrder;
import com.mercadolibre.dambetan01.repository.PurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.IPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@AllArgsConstructor
@Service
public class PayPurchaseOrderServiceImpl implements IPaymentService {

    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public ResponseEntity<Payment> PayPurchaseOrder(Long purchaseOrderId) {
        PurchaseOrder p1 = purchaseOrderRepository.findById(purchaseOrderId).orElseThrow(() -> new NotFoundException("Product " + purchaseOrderId));

        if (p1.getOrderStatus().equals(OrderStatus.PROCESSING)) {

            Payment pay = new Payment(null, Instant.now(), p1);
            p1.setPayment(pay);
            p1.setOrderStatus(OrderStatus.PREPARING);
            purchaseOrderRepository.save(p1);
            return ResponseEntity.accepted().body(pay.getOrder().getPayment());

        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
