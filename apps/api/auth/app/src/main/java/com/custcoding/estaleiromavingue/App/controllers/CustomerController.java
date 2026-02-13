package com.custcoding.estaleiromavingue.App.controllers;


import com.custcoding.estaleiromavingue.App.dtos.customer.CustomerCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.customer.CustomerResponseDTO;
import com.custcoding.estaleiromavingue.App.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {


    private final CustomerService customerService;

    @GetMapping("/")
    public List<CustomerResponseDTO> getCustomers(){
        return customerService.getCustomers() ;
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(
            @PathVariable("id") Long id
    ){
        return customerService.getCustomerById(id);
    }

/*    @GetMapping("/{name}")
    public CustomerResponseDTO getCustomerByName(
            @PathVariable("name") String name
    ){
        return ;
    }*/

    @PostMapping("/")
    public CustomerResponseDTO postCustomer(
            CustomerCreateDTO customer
    ){
        return customerService.postCustomer(customer);
    }
/*
    @PutMapping("/{id}")
    public CustomerResponseDTO updateCustomer(
            @PathVariable("id") Long id
    ){
        return ;
    }*/

    @DeleteMapping("/{id}")
    public void deleteCustomer(
            Long id
    ){
        customerService.deleteCustomer(id);
    }


}
