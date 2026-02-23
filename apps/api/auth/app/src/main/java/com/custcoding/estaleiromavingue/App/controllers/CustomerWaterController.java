package com.custcoding.estaleiromavingue.App.controllers;

import com.custcoding.estaleiromavingue.App.dtos.customer_water.CustomerWaterCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.customer_water.CustomerWaterResponseDTO;
import com.custcoding.estaleiromavingue.App.models.CustomerWater;
import com.custcoding.estaleiromavingue.App.services.CustomerWaterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer-water")
public class CustomerWaterController {


    private final CustomerWaterService customerWaterService;

    @GetMapping
    public List<CustomerWaterResponseDTO> getCustomers(){
        return customerWaterService.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerWaterResponseDTO> getCustomerById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(customerWaterService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerWaterResponseDTO> postCustomer(
            @Valid @RequestBody CustomerWaterCreateDTO customer
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerWaterService.postCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerWaterResponseDTO> updateCustomer(
            @PathVariable("id") Long id,
            @Valid @RequestBody CustomerWater customerDetails
    ){

        return ResponseEntity.ok(customerWaterService.updateCustomer(id,customerDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable("id") Long id
    ){
        customerWaterService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


}
