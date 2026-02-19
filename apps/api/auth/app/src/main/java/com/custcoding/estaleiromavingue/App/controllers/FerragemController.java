package com.custcoding.estaleiromavingue.App.controllers;

import com.custcoding.estaleiromavingue.App.dtos.ferragem.FerragemCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.ferragem.FerragemResponseDTO;
import com.custcoding.estaleiromavingue.App.models.Ferragem;
import com.custcoding.estaleiromavingue.App.services.FerragemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("/api/ferragem")
@RestController
public class FerragemController {

    private final FerragemService ferragemService;

    @GetMapping("/")
    public List<FerragemResponseDTO> getFerragens(){
        return this.ferragemService.getFerragens();
    }

    @GetMapping("/{id}")
    public FerragemResponseDTO getFerragemById(
            @PathVariable("id") Long id
    ){
        return this.ferragemService.getFerragemById(id);
    }

    @PostMapping("/")
    public FerragemResponseDTO postFerragem(
            @Valid @RequestBody FerragemCreateDTO ferragem
    ){
        return this.ferragemService.postFerragem(ferragem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FerragemResponseDTO> updateFerragem(
            @PathVariable("id") Long id,
            @Valid @RequestBody Ferragem ferragemDetails
    ){
        FerragemResponseDTO updatedFerragem = ferragemService.updateFerragem(id, ferragemDetails);

        return ResponseEntity.ok(updatedFerragem);
    }


    @DeleteMapping("/{id}")
    public void deleteFerragem(
            @PathVariable("id") Long id
    ){
        this.ferragemService.deleteFerragem(id);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handeMethodException(
            MethodArgumentNotValidException exception
    ){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
