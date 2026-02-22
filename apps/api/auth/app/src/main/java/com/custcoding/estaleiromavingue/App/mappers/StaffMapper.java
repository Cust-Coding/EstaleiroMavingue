package com.custcoding.estaleiromavingue.App.mappers;


import com.custcoding.estaleiromavingue.App.dtos.staff.StaffCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.staff.StaffResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Ferragem;
import com.custcoding.estaleiromavingue.App.models.Staff;
import org.springframework.stereotype.Service;

@Service
public class StaffMapper {

    public Staff toStuffDTO(StaffCreateDTO dto){
        var staff = new Staff();
        staff.setName(dto.name());
        staff.setRole(dto.role());
        staff.setPhone(dto.phone());

        Ferragem ferragem = new Ferragem();
        ferragem.setId(dto.ferragemId());
        staff.setFerragem(ferragem);

        return staff;
    }

    public StaffResponseDTO toStaffResponseDTO(
            Staff dto
    ){
        return new StaffResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getRole(),
                dto.getPhone(),
                dto.getCreated(),
                dto.getFerragem().getId(),
                dto.getFerragem().getName()
        );
    }



}
