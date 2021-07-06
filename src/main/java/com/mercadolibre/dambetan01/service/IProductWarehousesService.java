package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.dtos.response.ProductsWarehousesResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductWarehousesService {
    List<Batch> productIdFromWarehouses(Long productId);
}
