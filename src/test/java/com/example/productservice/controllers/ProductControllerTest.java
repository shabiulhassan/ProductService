package com.example.productservice.controllers;

import com.example.productservice.customExceptions.ProductNotFoundException;
import com.example.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    ProductController productController;
   // @Autowired
            @MockBean
    ProductService productService;

    @Test
    @DisplayName("Testing 1+1=2")
    void testOnePlusOneIsTwo(){
        //assert(2==1+1);
        assertEquals(2,1+1,"1+1 should be 2");
    }
@Test
    void testGetProductByIdNegativeTC(){
        assertThrows(ProductNotFoundException.class,()->productController.getProductById(1000L));
    }
    @Test
    void testGetProductByIdMocking() throws ProductNotFoundException{
        when(productService.getProductById(100L)).thenReturn(null);
        assertNull(productController.getProductById(100L));
    }
}
