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
    public AdressResponseDTO getAddressById(
            @PathVariable("id") Long id
    ){
        return this.adressService.getAddressById(id);
    }

    @PostMapping
    public AdressResponseDTO postAddress(
            @Valid @RequestBody AdressCreateDTO adress
    ){
        return this.adressService.postAddress(adress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdressResponseDTO> updateAddress(
            @PathVariable("id") Long id,
            @Valid @RequestBody Adress adressDetails
    ){
        AdressResponseDTO updatedAddress = adressService.updateAddress(id,adressDetails);
        return ResponseEntity.ok(updatedAddress);
    }


    @DeleteMapping("/{id}")
    public void deleteAddress(
            @PathVariable("id") Long id
    ){
        this.adressService.deleteAdress(id);
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
