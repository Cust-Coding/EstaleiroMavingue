package com.custcoding.estaleiromavingue.App.controllers;


import com.custcoding.estaleiromavingue.App.dtos.adress.AdressCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.adress.AdressResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Adress;
import com.custcoding.estaleiromavingue.App.services.AdressService;
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

@RequestMapping("/api/address")
@RestController
@AllArgsConstructor
public class AdressController {

    private final AdressService adressService;


    @GetMapping
    public List<AdressResponseDTO> getAddresses(){
        return this.adressService.getAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdressResponseDTO> getAddressById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(adressService.getAddressById(id));
    }

    @PostMapping
    public ResponseEntity<AdressResponseDTO> postAddress(
            @Valid @RequestBody AdressCreateDTO adress
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(adressService.postAddress(adress));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdressResponseDTO> updateAddress(
            @PathVariable("id") Long id,
            @Valid @RequestBody Adress adressDetails
    ){
        return ResponseEntity.ok(adressService.updateAddress(id,adressDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(
            @PathVariable("id") Long id
    ){
        adressService.deleteAdress(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodException(
            MethodArgumentNotValidException exception
    ){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }



}
