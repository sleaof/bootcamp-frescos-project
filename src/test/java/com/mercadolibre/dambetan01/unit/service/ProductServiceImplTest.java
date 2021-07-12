package com.mercadolibre.dambetan01.unit.service;

import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.enums.ProductCategory;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.service.crud.impl.ProductServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    ProductRepository repository = Mockito.mock(ProductRepository.class);
    ProductServiceImpl service;

    Product product;
    Product productNull = null;
    ProductDTO productDTO;
    List<Product> listOfProducts  = new ArrayList<>();
    List<Product> listOfProductsByCategory  = new ArrayList<>();

    @BeforeEach
    void setUp() {
        this.service = new ProductServiceImpl(repository, new ModelMapper());

        product = new Product(1L, "Carne", 0.0, LocalDate.of(2021, 5, 21), 20F, ProductCategory.FROZEN, null);
        productDTO = new ProductDTO(1L, "Carne", 0.0, LocalDate.of(2021, 5, 21), 20F, ProductCategory.FROZEN);

        listOfProducts.add(new Product(2L, "Peixe", 0.0, LocalDate.of(2021, 5, 21), 40F, ProductCategory.FRESH, null));
        listOfProducts.add(new Product(3L, "Maca", 0.0, LocalDate.of(2021, 5, 21), 60F, ProductCategory.REFRIGERATED, null));

        listOfProductsByCategory.add(product);
    }

    @Test
    void product_create_returnObj() {
        ProductDTO productCreate = service.create(productDTO);
        verify(repository).save(any());
    }

    @Test
    void product_update_returnObj() {
        ProductDTO productUpdate = service.update(productDTO);
        verify(repository).save(any());
    }

    @Test
    void product_delete_returnException() {
        when(repository.findById(100L)).thenReturn(Optional.ofNullable(productNull));
        assertThrows(NoSuchElementException.class, () -> service.delete(100L),
                "Não foi encontrado nenhum produto com este Id: 100");
    }

    @Test
    void product_delete_deletedObj() {
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(product));
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void product_findById_returnException() {
        when(repository.findById(100L)).thenReturn(Optional.ofNullable(productNull));
        assertThrows(NoSuchElementException.class, () -> service.findById(100L),
                "Não foi encontrado nenhum produto com este Id: 100");
    }

    @Test
    void product_findById_returnObject() {
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(product));
        ProductDTO productDTO = service.findById(1L);
        assertEquals("Carne", productDTO.getProductName());
    }

    @Test
    void product_findAll_returnList() {
        when(repository.findAll()).thenReturn(listOfProducts);
        List<ProductDTO> listOfProductsDTO = service.findAll();
        assertEquals("Maca", listOfProductsDTO.get(1).getProductName());
    }

    @Test
    void product_findByCategory_returnList() {
        when(repository.findByCategory("FROZEN")).thenReturn(listOfProductsByCategory);
        List<ProductDTO> listOfProductsDTO = service.findAll();
        assertEquals("Carne", listOfProductsByCategory.get(0).getProductName());
    }
}
