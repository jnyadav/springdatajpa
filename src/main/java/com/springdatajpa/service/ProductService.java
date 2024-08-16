package com.springdatajpa.service;

import com.springdatajpa.dto.ProductDto;
import com.springdatajpa.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProduct();

    ProductDto updateProduct(ProductDto productDto, long id);
}
