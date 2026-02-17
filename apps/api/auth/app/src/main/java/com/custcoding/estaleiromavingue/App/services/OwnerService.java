package com.custcoding.estaleiromavingue.App.services;


import com.custcoding.estaleiromavingue.App.dtos.owner.OwnerCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.owner.OwnerResponseDTO;
import com.custcoding.estaleiromavingue.App.mappers.OwnerMapper;
import com.custcoding.estaleiromavingue.App.repositories.OwnerRepository;
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
public class OwnerService {


    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;


    public List<OwnerResponseDTO> getOwners(){
        return ownerRepository.findAll()
                .stream()
                .map(ownerMapper::toOwnerResponseDTO)
                .collect(Collectors.toList());
    }

    public OwnerResponseDTO getOwnerById(
            Long id
    ){
        return ownerRepository.findById(id)
                .map(ownerMapper::toOwnerResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }


    public OwnerResponseDTO postOwner(
            OwnerCreateDTO request
    ){
        var owner = ownerMapper.toOwnerDTO(request);
        var savedOwner = ownerRepository.save(owner);
        return ownerMapper.toOwnerResponseDTO(savedOwner);
    }


    public void deleteOwner(
            Long id
    ){
        ownerRepository.deleteById(id);
    }


}
