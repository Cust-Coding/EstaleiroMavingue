package com.custcoding.estaleiromavingue.App.controllers;


import com.custcoding.estaleiromavingue.App.dtos.owner.OwnerCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.owner.OwnerResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Owner;
import com.custcoding.estaleiromavingue.App.services.OwnerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;


    @GetMapping
    public List<OwnerResponseDTO> getOwners(){
        return this.ownerService.getOwners();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerResponseDTO> getOwnerById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @PostMapping
    public ResponseEntity<OwnerResponseDTO> postOwner(
            @Valid @RequestBody OwnerCreateDTO owner
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ownerService.postOwner(owner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerResponseDTO> updateOwner(
            @PathVariable("id") Long id,
            @Valid @RequestBody Owner ownerDetails
    ){
        return ResponseEntity.ok(ownerService.updateOwner(id, ownerDetails));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(
            @PathVariable("id") Long id
    ){
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(
            MethodArgumentNotValidException exception
    ){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
