package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.model.Product;


public interface ProductService {

   Product findById(Long id) throws Throwable;
}
