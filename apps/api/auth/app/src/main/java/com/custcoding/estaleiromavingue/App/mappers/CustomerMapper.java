package com.custcoding.estaleiromavingue.App.mappers;

import com.custcoding.estaleiromavingue.App.dtos.customer.CustomerCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.customer.CustomerResponseDTO;
import com.custcoding.estaleiromavingue.App.models.CustomerProduto;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {


    public CustomerProduto toCustomerDTO(
            CustomerCreateDTO dto
    ){
        var customer = new CustomerProduto();
        customer.setNome(dto.nome());
        customer.setTelefone(dto.telefone());
        customer.setEmail(dto.email());
        return  customer;
    }


    public CustomerResponseDTO toCustomerResponseDTO(
            CustomerProduto dto
    ){
        return new CustomerResponseDTO(
                dto.getId(),
                dto.getNome(),
                dto.getTelefone(),
                dto.getEmail(),
                dto.getDataCriacao()
        );
    }


}
