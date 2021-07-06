package com.mercadolibre.dambetan01.service.crud;

import com.mercadolibre.dambetan01.dtos.ProductDTO;

import java.util.List;

public interface IProductService extends ICRUD<ProductDTO>{
    List<ProductDTO> findByCategory(String category);
}
