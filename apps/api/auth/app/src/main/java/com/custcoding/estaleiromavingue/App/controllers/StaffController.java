package com.custcoding.estaleiromavingue.App.controllers;


import com.custcoding.estaleiromavingue.App.dtos.staff.StaffCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.staff.StaffResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Staff;
import com.custcoding.estaleiromavingue.App.services.StaffService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<StaffResponseDTO> getStaffById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @PostMapping
    public ResponseEntity<StaffResponseDTO> postStaff(
            @Valid @RequestBody StaffCreateDTO staffDetails
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(staffService.postStaff(staffDetails));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffResponseDTO> updateStaff(
            @PathVariable Long id,
            @Valid @RequestBody Staff staffDetails
    ){
        return ResponseEntity.ok(staffService.updateStaff(id, staffDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(
            @PathVariable Long id
    ){
        staffService.getStaffById(id);
        return ResponseEntity.noContent().build();
    }



}
