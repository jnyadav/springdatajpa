package com.springdatajpa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springdatajpa.dto.ProductDto;
import com.springdatajpa.entity.Product;
import com.springdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

   @Autowired
    private ObjectMapper mapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product= mapper.convertValue(productDto, Product.class);
        Product saveProduct = productRepository.save(product);
      ProductDto dto = mapper.convertValue(saveProduct, ProductDto.class);

        return dto;
    }

    @Override
    public List<ProductDto> getAllProduct() {

       List<Product> product = productRepository.findAll();

        return product.stream()
                .map(x -> mapper.convertValue(x, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product is not found"));

        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());

       Product saveProduct = productRepository.save(existingProduct);
       ProductDto dto = mapper.convertValue(saveProduct, ProductDto.class);

        return dto;
    }
}
