package com.custcoding.estaleiromavingue.App.controllers;

import com.custcoding.estaleiromavingue.App.dtos.product.ProductCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.product.ProductResponseDTO;
import com.custcoding.estaleiromavingue.App.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    

    private final ProductService productService;

    @GetMapping("/")
    public List<ProductResponseDTO> getProducts(){
        return this.productService.getProducts() ;
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(
           @Valid @PathVariable("id") Long id
    ){
        return this.productService.getProductById(id);
    }

    /*    @GetMapping("/{name}")
    public CustomerResponseDTO getCustomerByName(
            @PathVariable("name") String name
    ){
        return ;
    }*/

    @PostMapping("/")
    public ProductResponseDTO postProduct(
           @Valid @RequestBody ProductCreateDTO product
    ){
            return this.productService.postProduct(product);
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
           @PathVariable("id") Long id
    ){
        this.productService.deleteProduct(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(
            MethodArgumentNotValidException exception
    ){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach(error -> {
                   var fieldName = ((FieldError) error).getField();
                   var errorMessage = error.getDefaultMessage();
                   errors.put(fieldName, errorMessage);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }



}
