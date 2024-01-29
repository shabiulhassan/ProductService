package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private String specificProductUrl="https://fakestoreapi.com/products/{id}";
    private String genericProductsUrl="https://fakestoreapi.com/products";
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
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);


       return convertToGenericProduct(response.getBody());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductsUrl,FakeStoreProductDto[].class);
        List<FakeStoreProductDto> allProducts= List.of(responseEntity.getBody());
        List<GenericProductDto> result =new ArrayList<>();
        for (FakeStoreProductDto fakestoreProductDto:
                allProducts) {
            result.add(convertToGenericProduct(fakestoreProductDto));
        }
        return result;
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.postForEntity(genericProductsUrl,genericProductDto, FakeStoreProductDto.class);
        return convertToGenericProduct(responseEntity.getBody());
    }

    @Override
    public void updateProductById() {

    }
}
