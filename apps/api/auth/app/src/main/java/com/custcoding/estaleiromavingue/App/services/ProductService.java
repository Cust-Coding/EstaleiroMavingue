package com.custcoding.estaleiromavingue.App.services;


import com.custcoding.estaleiromavingue.App.dtos.product.ProductCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.product.ProductResponseDTO;
import com.custcoding.estaleiromavingue.App.mappers.ProductMapper;
import com.custcoding.estaleiromavingue.App.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductResponseDTO> getProducts(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(
            Long id
    ){
        return productRepository.findById(id)
                .map(productMapper::toProductResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }


    public ProductResponseDTO postProduct(
            ProductCreateDTO request
    ){
        var product = productMapper.toProductDTO(request);
        var savedProduct = productRepository.save(product);
        return productMapper.toProductResponseDTO(savedProduct);
    }


    public void deleteProduct(
            Long id
    ){

        productRepository.deleteById(id);
    }




}
