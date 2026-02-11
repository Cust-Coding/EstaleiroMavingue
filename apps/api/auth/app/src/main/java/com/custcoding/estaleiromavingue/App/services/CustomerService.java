package com.custcoding.estaleiromavingue.App.services;


import com.custcoding.estaleiromavingue.App.dtos.CustomerCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.CustomerResponseDTO;
import com.custcoding.estaleiromavingue.App.mappers.CustomerMapper;
import com.custcoding.estaleiromavingue.App.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.LinkOption;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public List<CustomerResponseDTO> getCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponseDTO)
                .collect(Collectors.toList());
    }


    public CustomerResponseDTO getCustomerById(
            Long id
    ){
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }

    public CustomerResponseDTO postCustomer(
            CustomerCreateDTO request
    ){
        var customer = customerMapper.toCustomerDTO(request);
        var savedCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerResponseDTO(savedCustomer);
    }

    /*public CustomerResponseDTO updateCustomer(
            Long id
    ){
        return customerRepository.
    }
    */

    public void deleteCustomer(
            Long id
    ){
        customerRepository.deleteById(id);
    }



}
