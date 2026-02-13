package com.custcoding.estaleiromavingue.App.mappers;

import com.custcoding.estaleiromavingue.App.dtos.product.ProductCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.product.ProductResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Product;
import org.springframework.stereotype.Service;


@Service
public class ProductMapper {

    public Product toProductDTO(
            ProductCreateDTO dto

    ){
        var product = new Product();

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        return product;
    }


    public ProductResponseDTO toProductResponseDTO(
            Product dto
    ){
        return new ProductResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getPrice()
        );
    }


}
