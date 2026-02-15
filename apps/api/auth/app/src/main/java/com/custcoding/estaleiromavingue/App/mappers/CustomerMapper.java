package com.custcoding.estaleiromavingue.App.mappers;

import com.custcoding.estaleiromavingue.App.dtos.customer.CustomerCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.customer.CustomerResponseDTO;
import com.custcoding.estaleiromavingue.App.models.CustomerProduct;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {


    public CustomerProduct toCustomerDTO(
            CustomerCreateDTO dto
    ){
        var customer = new CustomerProduct();
        customer.setName(dto.name());
        customer.setPhone(dto.phone());
        customer.setEmail(dto.email());
        return  customer;
    }


    public CustomerResponseDTO toCustomerResponseDTO(
            CustomerProduct dto
    ){
        return new CustomerResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getCreated()
        );
    }


}
