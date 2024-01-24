package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private String getProductUrl="https://fakestoreapi.com/products/1";
    RestTemplateBuilder restTemplateBuilder;
    private static GenericProductDto convertToGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        return genericProductDto;
    }
    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){

        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity(getProductUrl, FakeStoreProductDto.class);


       return convertToGenericProduct(response.getBody());
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById() {

    }
}
