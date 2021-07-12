package com.mercadolibre.dambetan01.unit.service;

import com.mercadolibre.dambetan01.enums.OrderStatus;
import com.mercadolibre.dambetan01.exceptions.NotFoundException;
import com.mercadolibre.dambetan01.model.Payment;
import com.mercadolibre.dambetan01.model.PurchaseOrder;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.repository.PurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.impl.PayPurchaseOrderServiceImpl;
import com.mercadolibre.dambetan01.service.impl.ProdServiceImpl;
import com.mercadolibre.dambetan01.service.impl.ProductWarehousesServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class PaymentPurchaseOrderTest {
    PurchaseOrder p1,p2;
    ResponseEntity pr;

    PurchaseOrderRepository purchaseOrderRepository = Mockito.mock(PurchaseOrderRepository.class);
    //ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    PayPurchaseOrderServiceImpl service;

    @BeforeEach
    void setUp() {

        this.service = new PayPurchaseOrderServiceImpl(purchaseOrderRepository);
      //  this.productWarehousesService = new ProductWarehousesServiceImpl(batchRepository, service, repository);

        p1 = new PurchaseOrder(1L, Date.from(Instant.now()), OrderStatus.PROCESSING, null,null,null);
        p2 = new PurchaseOrder(2L, Date.from(Instant.now()), OrderStatus.PREPARING, null,null,null);
        Payment pagamento = new Payment(1L,Instant.now(),p1);
        p1.setPayment(pagamento);
        pr = ResponseEntity.status(HttpStatus.ACCEPTED).body(pagamento);
    }

    @Test
    void payPurchaseOrderACCEPTED() {

        when(purchaseOrderRepository.findById(1L)).thenReturn(Optional.of(p1));
        when(service.PayPurchaseOrder(1L)).thenReturn(pr);

        ResponseEntity<Payment> pay1 = service.PayPurchaseOrder(1L);

        Assert.assertEquals(pay1, service.PayPurchaseOrder(1L));
    }

    @Test
    void payPurchaseOrderBAD_REQUEST() {

        when(purchaseOrderRepository.findById(2L)).thenReturn(Optional.of(p2));

        ResponseEntity<Payment> pay1 = service.PayPurchaseOrder(2L);

        Assert.assertEquals(pay1, service.PayPurchaseOrder(2L));
    }

    @Test
    void findPurchaseOrderNotFoundException() {
        when(purchaseOrderRepository.findById(1L)).thenReturn(Optional.of(p1));
        assertThrows(NotFoundException.class, () -> service.PayPurchaseOrder(1L), "Product not exist");
    }
}