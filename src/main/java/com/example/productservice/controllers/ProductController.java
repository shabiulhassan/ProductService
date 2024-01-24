package com.example.productservice.controllers;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id")  Long id){

        return productService.getProductById(id);
    }
    @GetMapping
    public void getAllProducts(){

    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id){

    }
    public void createProduct(){

    }
    public void updateProductById(){

    }

}
