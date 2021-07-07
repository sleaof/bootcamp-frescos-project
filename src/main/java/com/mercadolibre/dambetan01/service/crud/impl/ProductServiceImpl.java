package com.mercadolibre.dambetan01.service.crud.impl;

import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.service.crud.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;

    private ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);

        return productDTO;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);

        return productDTO;
    }

    @Override
    public void delete(Long id) {
        Optional<Product> opt = productRepository.findById(id);
        if (!opt.isPresent()) {
            throw new NoSuchElementException("There is no Product with this Id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> opt = productRepository.findById(id);

        if (!opt.isPresent()) {
            throw new NoSuchElementException("There is no Product with this Id: " + id);
        }
        return modelMapper.map(opt.get(), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByCategory(String category) {
        return productRepository.findByCategory(category)
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

}
