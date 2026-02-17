package com.custcoding.estaleiromavingue.App.mappers;


import com.custcoding.estaleiromavingue.App.dtos.owner.OwnerCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.owner.OwnerResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Owner;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapper {


    public Owner toOwnerDTO(OwnerCreateDTO dto){
        var owner = new Owner();
        owner.setName(dto.name());
        owner.setPhone(dto.phone());
        owner.setEmail(dto.email());
        owner.setNuit(dto.nuit());
        return owner;
    }

    public OwnerResponseDTO toOwnerResponseDTO(Owner dto){
        return new OwnerResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getNuit(),
                dto.getCreated()
        );
    }


}
