package com.mercadolibre.dambetan01.unit.controller;

import com.mercadolibre.dambetan01.controller.PayPurchaseOrderController;
import com.mercadolibre.dambetan01.controller.ProductsWarehouseController;
import com.mercadolibre.dambetan01.enums.OrderStatus;
import com.mercadolibre.dambetan01.model.Payment;
import com.mercadolibre.dambetan01.model.PurchaseOrder;
import com.mercadolibre.dambetan01.repository.PurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.impl.PayPurchaseOrderServiceImpl;
import com.mercadolibre.dambetan01.service.impl.ProductWarehousesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PayPurchaseOrderControllerTest {

    PurchaseOrder p1,p2;
    ResponseEntity pr;

    PayPurchaseOrderController controller;
    PayPurchaseOrderServiceImpl service = Mockito.mock(PayPurchaseOrderServiceImpl.class);

    @BeforeEach
    void setUp() {
        controller = new PayPurchaseOrderController(service);
        //  this.productWarehousesService = new ProductWarehousesServiceImpl(batchRepository, service, repository);

        p1 = new PurchaseOrder(1L, Date.from(Instant.now()), OrderStatus.PROCESSING, null,null,null);
        p2 = new PurchaseOrder(2L, Date.from(Instant.now()), OrderStatus.PREPARING, null,null,null);
        Payment pagamento = new Payment(1L,Instant.now(),p1);
        p1.setPayment(pagamento);
        pr = ResponseEntity.status(HttpStatus.ACCEPTED).body(pagamento);
    }
    @Test
    void product_selectedAllProducts_returnException() throws Throwable {
        when(service.PayPurchaseOrder(2L)).thenReturn(pr);
        ResponseEntity<Payment> paymentResponseEntity = controller.PayPurchaseOrder(2L);
        assertEquals(pr, paymentResponseEntity);

    }
}
