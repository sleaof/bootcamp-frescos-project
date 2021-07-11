package com.mercadolibre.dambetan01.unit.controller;

import com.mercadolibre.dambetan01.controller.PurchaseOrderController;
import com.mercadolibre.dambetan01.controller.SessionController;
import com.mercadolibre.dambetan01.dtos.ProductBatchOrderDTO;
import com.mercadolibre.dambetan01.dtos.PurchaseOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.AccountResponseDTO;
import com.mercadolibre.dambetan01.dtos.response.TotalPriceResponseDTO;
import com.mercadolibre.dambetan01.enums.OrderStatus;
import com.mercadolibre.dambetan01.exceptions.ApiException;
import com.mercadolibre.dambetan01.service.ISessionService;
import com.mercadolibre.dambetan01.service.crud.IPurchaseOrderService;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class PurchaseOrderControllerTest {
    PurchaseOrderController controller;
    IPurchaseOrderService service = Mockito.mock(IPurchaseOrderService.class);
    PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();

    @BeforeEach
    void setUp() throws NotFoundException {
        List<ProductBatchOrderDTO> productBatchOrderDTO = new ArrayList<>();


        productBatchOrderDTO.add(new ProductBatchOrderDTO(1L, 2));
        productBatchOrderDTO.add(new ProductBatchOrderDTO(2L, 4));

        purchaseOrderDTO.setOrderStatus(OrderStatus.PROCESSING);
        purchaseOrderDTO.setBuyer(1L);
        purchaseOrderDTO.setDate(new Date());
        purchaseOrderDTO.setProducts(productBatchOrderDTO);
        //when(service.login("user_one", "contra12"))
        //        .thenThrow(new ApiException("404", "Usuario y/o contraseña incorrecto", 404));
        when(service.calcTotalValue(purchaseOrderDTO))
                .thenReturn(new TotalPriceResponseDTO(12.0));

        controller = new PurchaseOrderController(service);
    }

    @Test
    void createOrderOK() throws Exception {
        System.out.println(purchaseOrderDTO);
        controller.createOrder(purchaseOrderDTO);
        ResponseEntity<TotalPriceResponseDTO> totalPriceResponseDTO = new ResponseEntity<>(service.calcTotalValue(purchaseOrderDTO), HttpStatus.CREATED);
        ResponseEntity<TotalPriceResponseDTO> expected = new ResponseEntity<>(new TotalPriceResponseDTO(12.0), HttpStatus.CREATED);
        assertEquals(expected, totalPriceResponseDTO);
    }

//    @Test
//    void loginFail() throws Exception {
//        assertThrows(ApiException.class, () -> controller.login("user_one","contra12"),
//                "Usuario y/o contraseña incorrecto");
//    }

//    @Test
//    void createOrderFail() throws Exception {
//        purchaseOrderDTO.setBuyer(null);
//
//        assertThrows(controller.createOrder(purchaseOrderDTO),new ResponseEntity<>(new TotalPriceResponseDTO(12.0), HttpStatus.CREATED));
////        AccountResponseDTO accountDTO = controller.login("user_one","contra123");
////        assertEquals("user_one", accountDTO.getUsername());
////        assertEquals("contra123", accountDTO.getPassword());
////        assertEquals("TOKEN", accountDTO.getToken());
//    }
}
