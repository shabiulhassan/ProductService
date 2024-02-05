package com.example.productservice.services;

import com.example.productservice.customExceptions.ProductNotFoundException;
import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreClient fakeStoreClient;
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
    FakeStoreProductService(FakeStoreClient fakeStoreClient){

        this.fakeStoreClient=fakeStoreClient;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException{


       return convertToGenericProduct(fakeStoreClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> allProducts= fakeStoreClient.getAllProducts();
        List<GenericProductDto> result =new ArrayList<>();
        for (FakeStoreProductDto fakestoreProductDto:
                allProducts) {
            result.add(convertToGenericProduct(fakestoreProductDto));
        }
        return result;
    }

    public GenericProductDto deleteProductById(Long id) {

        return convertToGenericProduct(fakeStoreClient.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {

        return convertToGenericProduct(fakeStoreClient.createProduct(genericProductDto));
    }

    @Override
    public  GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto) {

          return convertToGenericProduct(fakeStoreClient.updateProductById(id,genericProductDto));
    }
}
