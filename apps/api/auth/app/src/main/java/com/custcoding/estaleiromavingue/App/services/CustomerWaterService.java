package com.custcoding.estaleiromavingue.App.services;

import com.custcoding.estaleiromavingue.App.dtos.customer_water.CustomerWaterCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.customer_water.CustomerWaterResponseDTO;
import com.custcoding.estaleiromavingue.App.mappers.CustomerWaterMapper;
import com.custcoding.estaleiromavingue.App.repositories.CustomerWaterRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class CustomerWaterService {

    private final CustomerWaterRepository customerWaterRepository;
    private final CustomerWaterMapper customerWaterMapper;


    public List<CustomerWaterResponseDTO> getCustomers(){
        return customerWaterRepository.findAll()
                .stream()
                .map(customerWaterMapper::toCustomerResponseDTO)
                .collect(Collectors.toList());
    }


    public CustomerWaterResponseDTO getCustomerById(
            Long id
    ){
        return customerWaterRepository.findById(id)
                .map(customerWaterMapper::toCustomerResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }

    public CustomerWaterResponseDTO postCustomer(
            CustomerWaterCreateDTO request
    ){
        var customer = customerWaterMapper.toCustomerWaterDTO(request);
        var savedCustomer = customerWaterRepository.save(customer);
        return customerWaterMapper.toCustomerResponseDTO(savedCustomer);
    }


    public void deleteCustomer(
            Long id
    ){
        customerWaterRepository.deleteById(id);
    }



}
