package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IProductWarehousesService {

    ResponseEntity<ProductsWarehousesResponseDTO> productIdFromWarehouses(Long productId) throws Throwable;

}
