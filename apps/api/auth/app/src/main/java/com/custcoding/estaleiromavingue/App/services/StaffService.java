package com.custcoding.estaleiromavingue.App.services;


import com.custcoding.estaleiromavingue.App.dtos.staff.StaffCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.staff.StaffResponseDTO;
import com.custcoding.estaleiromavingue.App.mappers.StaffMapper;
import com.custcoding.estaleiromavingue.App.models.Staff;
import com.custcoding.estaleiromavingue.App.repositories.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;


    public List<StaffResponseDTO> getStaffs(){
        return staffRepository.findAll()
                .stream()
                .map(staffMapper::toStaffResponseDTO)
                .collect(Collectors.toList());
    }

    public StaffResponseDTO getStaffById(
            Long id
    ){
        return staffRepository.findById(id)
                .map(staffMapper::toStaffResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }

    public StaffResponseDTO postStaff(
            StaffCreateDTO request
    ){
        var staff = staffMapper.toStuffDTO(request);
        var savedStaff = staffRepository.save(staff);
        return staffMapper.toStaffResponseDTO(savedStaff);
    }

    public StaffResponseDTO updateStaff(
            Long id,
            Staff staffDetails
    ){
        var updatedStaff = staffRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "staff not found"
                ));
        updatedStaff.setName(staffDetails.getName());
        updatedStaff.setRole(staffDetails.getRole());
        updatedStaff.setPhone(staffDetails.getPhone());
        updatedStaff.setFerragem(staffDetails.getFerragem());

        var savedStaff = staffRepository.save(updatedStaff);

        return staffMapper.toStaffResponseDTO(savedStaff);

    }

    public  void deleteStaff(
            Long id
    ){
        staffRepository.deleteById(id);
    }


}
