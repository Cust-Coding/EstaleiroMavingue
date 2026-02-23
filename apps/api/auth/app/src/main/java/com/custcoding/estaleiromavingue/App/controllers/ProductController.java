package com.custcoding.estaleiromavingue.App.controllers;

import com.custcoding.estaleiromavingue.App.dtos.product.ProductCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.product.ProductResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Product;
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

    @GetMapping
    public List<ProductResponseDTO> getProducts(){
        return this.productService.getProducts() ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(
           @Valid @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    /*    @GetMapping("/{name}")
    public CustomerResponseDTO getCustomerByName(
            @PathVariable("name") String name
    ){
        return ;
    }*/

    @PostMapping
    public ResponseEntity<ProductResponseDTO> postProduct(
           @Valid @RequestBody ProductCreateDTO product
    ){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(productService.postProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable("id") Long id,
            @Valid @RequestBody Product productDetails
    ){
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
           @PathVariable("id") Long id
    ){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
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
