package com.example.productservice.thirdPartyClients.fakeStoreClient;

import com.example.productservice.customExceptions.ProductNotFoundException;
import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class FakeStoreClient {
 private String specificProductUrl;
    private String genericProductsUrl ;
    RestTemplateBuilder restTemplateBuilder;

    FakeStoreClient(RestTemplateBuilder restTemplateBuilder,
                    @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                    @Value("${fakestore.api.paths.products}") String fakeStoreApiProductsUrl){

        this.restTemplateBuilder=restTemplateBuilder;
        this.specificProductUrl= fakeStoreApiUrl+fakeStoreApiProductsUrl+"/{id}";
        this.genericProductsUrl=fakeStoreApiUrl+fakeStoreApiProductsUrl;
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);
        if(response.getBody()==null){
            throw new ProductNotFoundException("Product with id: "+id+" doesn't exist");
        }

        return response.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductsUrl,FakeStoreProductDto[].class);
       return List.of(responseEntity.getBody());
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback =
                restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity= restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.
                postForEntity(genericProductsUrl,genericProductDto, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }


    public  FakeStoreProductDto updateProductById(Long id,GenericProductDto genericProductDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        FakeStoreProductDto responseEntity=
                restTemplate.patchForObject(specificProductUrl,genericProductDto,FakeStoreProductDto.class,id);
        return responseEntity;
    }
}
