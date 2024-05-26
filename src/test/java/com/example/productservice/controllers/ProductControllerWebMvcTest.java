//package com.example.productservice.controllers;
//
//import com.example.productservice.dtos.GenericProductDto;
//import com.example.productservice.repositories.ProductRepository;
//import com.example.productservice.services.ProductService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.inject.Inject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(ProductController.class)
//public class ProductControllerWebMvcTest {
//    @MockBean
//    private ProductService productService;
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//    @Test
//    void getAllProductsReturnsEmptyList() throws Exception {
//        //when(productService.getAllProducts()).thenReturn(new ArrayList<>());
//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//        genericProductDtos.add(new GenericProductDto());
//        genericProductDtos.add(new GenericProductDto());
//        genericProductDtos.add(new GenericProductDto());
//
//        when(productService.getAllProducts()).thenReturn(genericProductDtos);
//
//        mockMvc.perform(get("/products"))
//                .andExpect(status().is(200))
//                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
//    }
////    @Test
////    void creatProductShouldCreateValidProduct() throws Exception {
////        GenericProductDto productToCreateDto=new GenericProductDto();
////        productToCreateDto.setTitle("Macbook");
////        productToCreateDto.setPrice(200000);
////        productToCreateDto.setDescription("Fastest Mac");
////        productToCreateDto.setCategory("Laptop");
////        GenericProductDto outputGenericProductDto = new GenericProductDto();
////        outputGenericProductDto.setCategory(productToCreateDto.getCategory());
////        outputGenericProductDto.setDescription(productToCreateDto.getDescription());
////        outputGenericProductDto.setTitle(productToCreateDto.getTitle());
////        outputGenericProductDto.setPrice(productToCreateDto.getPrice());
////        outputGenericProductDto.setId(1000L);
////
////        when(productService.createProduct(any()))
////                .thenReturn(outputGenericProductDto);
////
////        mockMvc.perform(post("/products")
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(objectMapper.writeValueAsString(productToCreateDto))
////        )
////                .andExpect(
////                        content().string(objectMapper.writeValueAsString(outputGenericProductDto))
////                )
////                .andExpect(status().is(200));
////    }
//}
