package com.mercadolibre.dambetan01.unit.service;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import com.mercadolibre.dambetan01.service.ProductService;
import com.mercadolibre.dambetan01.service.impl.ProdServiceImpl;
import com.mercadolibre.dambetan01.service.impl.ProductWarehousesServiceImpl;
import com.mercadolibre.dambetan01.exceptions.NotFoundException;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.Optional;
import org.junit.Assert;
import java.util.List;

public class ProductWarehousesServiceImplTest {

    ResponseEntity<ProductsWarehousesResponseDTO> pr;
    List<JSONObject> json;
    Product p;

    ProductRepository repository = Mockito.mock(ProductRepository.class);
    ProductService service;

    BatchRepository batchRepository = Mockito.mock(BatchRepository.class);
    ProductWarehousesServiceImpl productWarehousesService;

    @BeforeEach
    void setUp(){

        this.service = new ProdServiceImpl(repository);
        this.productWarehousesService= new ProductWarehousesServiceImpl(batchRepository,service,repository);

        p = new Product(1L, "carne", 10.0, LocalDate.of(2020, 06, 24), 30.0f, null, null);

        ArrayList products = new ArrayList();
        products.add(p);

        org.json.simple.JSONObject list = new org.json.simple.JSONObject();
        list.put("warehousesCode", 1);
        list.put("totalQuantity", 20);

        json = new ArrayList<>();
        json.add(list);

        ProductsWarehousesResponseDTO pro = new ProductsWarehousesResponseDTO(1L, json);

        pr = ResponseEntity.status(HttpStatus.ACCEPTED).body(pro);


    }

    @Test
    void findProductNotFoundException() {
        when(repository.findById(5L)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> service.findById(5L), "Product not exist");
    }

    @Test
    void findProductOk() {
        when(repository.findById(1L)).thenReturn(Optional.of(p));
        Assert.assertEquals(p,service.findById(1L));
    }

    @Test
    void findProductFromWareHouseACCEPTED() throws Throwable {

        when(repository.findById(1L)).thenReturn(Optional.of(p));
        when(batchRepository.productIdFromWarehouses(1L)).thenReturn(json);

        Assert.assertEquals(pr,productWarehousesService.productIdFromWarehouses(1L));
    }

}
