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

    @GetMapping
    public List<FerragemResponseDTO> getFerragens(){
        return this.ferragemService.getFerragens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FerragemResponseDTO> getFerragemById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(ferragemService.getFerragemById(id));
    }

    @PostMapping
    public ResponseEntity<FerragemResponseDTO> postFerragem(
            @Valid @RequestBody FerragemCreateDTO ferragem
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ferragemService.postFerragem(ferragem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FerragemResponseDTO> updateFerragem(
            @PathVariable("id") Long id,
            @Valid @RequestBody Ferragem ferragemDetails
    ){

        return ResponseEntity.ok(ferragemService.updateFerragem(id, ferragemDetails));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFerragem(
            @PathVariable("id") Long id
    ){
        ferragemService.deleteFerragem(id);
        return ResponseEntity.noContent().build();
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
