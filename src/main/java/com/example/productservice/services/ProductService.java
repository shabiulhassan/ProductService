package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id);
    List<GenericProductDto> getAllProducts();
   void deleteProductById(Long id);
    void createProduct();
    void updateProductById();
}
