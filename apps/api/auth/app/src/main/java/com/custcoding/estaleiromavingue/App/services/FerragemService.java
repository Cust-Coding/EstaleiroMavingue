package com.custcoding.estaleiromavingue.App.services;


import com.custcoding.estaleiromavingue.App.dtos.customer.CustomerResponseDTO;
import com.custcoding.estaleiromavingue.App.dtos.ferragem.FerragemCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.ferragem.FerragemResponseDTO;
import com.custcoding.estaleiromavingue.App.mappers.FerragemMapper;
import com.custcoding.estaleiromavingue.App.models.CustomerProduct;
import com.custcoding.estaleiromavingue.App.models.Ferragem;
import com.custcoding.estaleiromavingue.App.repositories.FerragemRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class FerragemService {

    private final FerragemRepository ferragemRepository;
    private final FerragemMapper ferragemMapper;


    public List<FerragemResponseDTO> getFerragens(){
        return ferragemRepository.findAll()
                .stream()
                .map(ferragemMapper::toFerragemResponseDTO)
                .collect(Collectors.toList());
    }

    public FerragemResponseDTO getFerragemById(
            Long id
    ){
        return ferragemRepository.findById(id)
                .map(ferragemMapper::toFerragemResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }


    public FerragemResponseDTO postFerragem(
            FerragemCreateDTO request
    ){
        var ferragem = ferragemMapper.toFerragemDTO(request);
        var savedFerragem = ferragemRepository.save(ferragem);
        return ferragemMapper.toFerragemResponseDTO(savedFerragem);
    }

    public FerragemResponseDTO updateFerragem(
            Long id,
            Ferragem ferragemDetails
    ){
        var updatedFerragem = ferragemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
        updatedFerragem.setName(ferragemDetails.getName());
        updatedFerragem.setBairro(ferragemDetails.getBairro());
        updatedFerragem.setOwner(ferragemDetails.getOwner());

        var savedFerragem = ferragemRepository.save(updatedFerragem);
        return ferragemMapper.toFerragemResponseDTO(savedFerragem);
    }


    public void deleteFerragem(
            Long id
    ){
        ferragemRepository.deleteById(id);
    }

}
