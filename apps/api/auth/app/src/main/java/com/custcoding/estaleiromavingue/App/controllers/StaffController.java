package com.custcoding.estaleiromavingue.App.controllers;


import com.custcoding.estaleiromavingue.App.dtos.staff.StaffCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.staff.StaffResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Staff;
import com.custcoding.estaleiromavingue.App.services.StaffService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@AllArgsConstructor
public class StaffController {


    private final StaffService staffService;


    @GetMapping
    public List<StaffResponseDTO> getStaffs(){
        return staffService.getStaffs();
    }


    @GetMapping("/{id}")
    public StaffResponseDTO getStaffById(
            @PathVariable("id") Long id
    ){
        return staffService.getStaffById(id);
    }

    @PostMapping
    public StaffResponseDTO postStaff(
            @Valid @RequestBody StaffCreateDTO staffDetails
    ){
        return staffService.postStaff(staffDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffResponseDTO> updateStaff(
            @PathVariable Long id,
            @Valid @RequestBody Staff staffDetails

    ){
        StaffResponseDTO staff  = staffService.updateStaff(id, staffDetails);
        return ResponseEntity.ok(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(
            @PathVariable Long id
    ){
        staffService.getStaffById(id);
    }



}
