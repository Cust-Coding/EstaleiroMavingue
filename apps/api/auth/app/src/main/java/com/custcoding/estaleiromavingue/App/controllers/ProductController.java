package com.custcoding.estaleiromavingue.App.controllers;

import com.custcoding.estaleiromavingue.App.dtos.product.ProductCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.product.ProductResponseDTO;
import com.custcoding.estaleiromavingue.App.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    

    private final ProductService productService;

    @GetMapping("/")
    public List<ProductResponseDTO> getProducts(){
        return productService.getProducts() ;
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(
            @PathVariable("id") Long id
    ){
        return productService.getProductById(id);
    }

    /*    @GetMapping("/{name}")
    public CustomerResponseDTO getCustomerByName(
            @PathVariable("name") String name
    ){
        return ;
    }*/

    @PostMapping("/")
    public ProductResponseDTO postProduct(
            ProductCreateDTO product
    ){
            return productService.postProduct(product);
        }
    /*
    @PutMapping("/{id}")
    public CustomerResponseDTO updateCustomer(
            @PathVariable("id") Long id
    ){
        return ;
    }*/

    @DeleteMapping("/{id}")
    public void deleteProduct(
            Long id
    ){
        productService.deleteProduct(id);
    }


}
