package com.example.productservice.services;

import com.example.productservice.customExceptions.ProductNotFoundException;
import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws ProductNotFoundException;
    List<GenericProductDto> getAllProducts();
   GenericProductDto deleteProductById(Long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);
}
