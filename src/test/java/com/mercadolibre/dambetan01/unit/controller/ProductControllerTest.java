package com.mercadolibre.dambetan01.unit.controller;

import com.mercadolibre.dambetan01.controller.ProductController;
import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.exceptions.NotFoundException;
import com.mercadolibre.dambetan01.service.crud.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

public class ProductControllerTest {

    ProductController controller;
    ProductServiceImpl service = Mockito.mock(ProductServiceImpl.class);

    List<ProductDTO> listOfProductNull = null;

    @BeforeEach
    void setUp() throws NotFoundException {
        controller = new ProductController(service);
    }

    @Test
    void product_selectedAllProducts_returnException() {
        when(service.findAll()).thenReturn(listOfProductNull);
        //controller.selectedAllProducts();
        //assertEquals(controller.selectedAllProducts(), ResponseEntity.notFound());
        //assertSame(controller.selectedAllProducts().getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void selectedAllProductsByCategory() {

    }

    @Test
    void selectedTheThreeBestSellingProducts() {

    }
}
