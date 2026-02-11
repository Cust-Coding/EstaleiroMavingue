package com.custcoding.estaleiromavingue.App.mappers;

import com.custcoding.estaleiromavingue.App.dtos.CustomerCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.CustomerResponseDTO;
import com.custcoding.estaleiromavingue.App.models.ClienteProduto;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {


    public ClienteProduto toCustomerDTO(
            CustomerCreateDTO dto
    ){
        var customer = new ClienteProduto();
        customer.setNome(dto.nome());
        customer.setTelefone(dto.telefone());
        customer.setEmail(dto.email());
        return  customer;
    }


    public CustomerResponseDTO toCustomerResponseDTO(
            ClienteProduto dto
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
