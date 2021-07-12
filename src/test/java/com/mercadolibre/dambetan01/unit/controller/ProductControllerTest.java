package com.mercadolibre.dambetan01.unit.controller;

import com.mercadolibre.dambetan01.controller.ProductController;
import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.dtos.response.TopSellersResponseDTO;
import com.mercadolibre.dambetan01.enums.ProductCategory;
import com.mercadolibre.dambetan01.service.crud.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    ProductController controller;
    ProductServiceImpl service = Mockito.mock(ProductServiceImpl.class);

    List<ProductDTO> listOfProductNull = new ArrayList<>();
    List<ProductDTO> listProducts = new ArrayList<>();
    List<TopSellersResponseDTO> topSellersResponseDTOList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        controller = new ProductController(service);

        listProducts.add(new ProductDTO(1L, "Carne", 0.0, LocalDate.of(2021, 5, 21), 20F, ProductCategory.FROZEN));

        topSellersResponseDTOList.add(new TopSellersResponseDTO("Extrema", "Massa-Congelada", 6L));
    }

    @Test
    void product_selectedAllProducts_returnException() {
        when(service.findAll()).thenReturn(listOfProductNull);
        assertSame(controller.selectedAllProducts().getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void product_selectedAllProducts_returnList() {
        when(service.findAll()).thenReturn(listProducts);
        assertSame(controller.selectedAllProducts().getStatusCode(), HttpStatus.OK);
    }

    @Test
    void product_selectedAllProductsByCategory_returnException() {
        when(service.findByCategory("REFRIGERATED")).thenReturn(listOfProductNull);
        assertSame(controller.selectedAllProductsByCategory("REFRIGERATED").getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void product_selectedAllProductsByCategory_returnList() {
        when(service.findByCategory("FROZEN")).thenReturn(listProducts);
        assertSame(controller.selectedAllProductsByCategory("FROZEN").getStatusCode(), HttpStatus.OK);
    }

    @Test
    void product_selectedTheThreeBestSellingProducts_returnList() {
        when(service.findTheThreeBestSellingProducts()).thenReturn(topSellersResponseDTOList);
        assertSame(controller.selectedTheThreeBestSellingProducts().getStatusCode(), HttpStatus.OK);
    }
}
