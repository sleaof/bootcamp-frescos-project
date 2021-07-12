package com.mercadolibre.dambetan01.unit.controller;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import com.mercadolibre.dambetan01.model.Payment;
import com.mercadolibre.dambetan01.service.impl.ProductWarehousesServiceImpl;
import com.mercadolibre.dambetan01.controller.ProductsWarehouseController;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.mercadolibre.dambetan01.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.when;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductsWarehouseControllerTest {

    ResponseEntity<ProductsWarehousesResponseDTO> pr;
    ResponseEntity<ProductsWarehousesResponseDTO> pr2;
    List<JSONObject> json;
    Product product1;
    Product product2;

    ProductsWarehouseController controller;
    ProductWarehousesServiceImpl service = Mockito.mock(ProductWarehousesServiceImpl.class);

    @BeforeEach
    void setUp() throws Throwable {
        controller = new ProductsWarehouseController(service);

        product1 = new Product(1L, "carne", 10.0, LocalDate.of(2020, 06, 24), 30.0f, null, null);
        product2 = new Product(2L, "arroz", 10.0, LocalDate.of(2020, 06, 24), 20.0f, null, null);
        ArrayList products = new ArrayList();

        products.add(product1);
        products.add(product2);

        org.json.simple.JSONObject list = new org.json.simple.JSONObject();
        list.put("warehousesCode", 1);
        list.put("totalQuantity", 20);

        json = new ArrayList<>();
        json.add(list);

        ProductsWarehousesResponseDTO pro = new ProductsWarehousesResponseDTO(1L, json);
        ProductsWarehousesResponseDTO pro2 = new ProductsWarehousesResponseDTO(2L, json);

        pr = ResponseEntity.status(HttpStatus.ACCEPTED).body(pro);
        pr2 = ResponseEntity.status(HttpStatus.ACCEPTED).body(pro2);

        when(service.productIdFromWarehouses(1L)).thenReturn(pr);
        when(service.productIdFromWarehouses(2L)).thenReturn(pr2);

    }

    @Test
    void product_selectedAllProducts_returnException() throws Throwable {

        ResponseEntity productIdFromWarehouses = controller.productIdFromWarehouses(2L);
        assertEquals(pr2, productIdFromWarehouses);

    }

}
