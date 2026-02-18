package com.custcoding.estaleiromavingue.App.mappers;

import com.custcoding.estaleiromavingue.App.dtos.customer_water.CustomerWaterCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.customer_water.CustomerWaterResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Adress;
import com.custcoding.estaleiromavingue.App.models.CustomerWater;
import org.springframework.stereotype.Service;

@Service
public class CustomerWaterMapper {

    public CustomerWater toCustomerWaterDTO(
            CustomerWaterCreateDTO dto
    ){
        var customer = new CustomerWater();
        customer.setName(dto.name());
        customer.setPhone(dto.phone());
        customer.setEmail(dto.email());
        customer.setHouseNR(dto.houseNR());

        var adress = new Adress();
        adress.setId(dto.adressId());

        customer.setAdressId(adress);

        return customer;
    }

    public CustomerWaterResponseDTO toCustomerResponseDTO(
            CustomerWater dto
    ){
        var adress = dto.getAdressId();
        return new CustomerWaterResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getHouseNR(),
                adress.getName(),
                adress.getBairro(),
                dto.getCreated()

        );
    }



}
