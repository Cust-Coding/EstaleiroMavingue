package com.custcoding.estaleiromavingue.App.controllers;

import com.custcoding.estaleiromavingue.App.dtos.customer_water.CustomerWaterCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.customer_water.CustomerWaterResponseDTO;
import com.custcoding.estaleiromavingue.App.models.CustomerWater;
import com.custcoding.estaleiromavingue.App.services.CustomerWaterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
    public CustomerWaterResponseDTO getCustomerById(
            @PathVariable("id") Long id
    ){
        return customerWaterService.getCustomerById(id);
    }


    @PostMapping
    public CustomerWaterResponseDTO postCustomer(
            @Valid @RequestBody CustomerWaterCreateDTO customer
    ){
        return customerWaterService.postCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerWaterResponseDTO> updateCustomer(
            @PathVariable("id") Long id,
            @Valid @RequestBody CustomerWater customerDetails
    ){
        CustomerWaterResponseDTO customer = customerWaterService.updateCustomer(id,customerDetails);

        return ResponseEntity.ok(customer);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(
            @PathVariable("id") Long id
    ){
        customerWaterService.deleteCustomer(id);
    }


}
