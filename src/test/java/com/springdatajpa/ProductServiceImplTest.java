package com.springdatajpa;

import com.springdatajpa.repository.ProductRepository;
import com.springdatajpa.service.ProductServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProductServiceImplTest.class)
public class ProductServiceImplTest {

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductServiceImpl service;

}
