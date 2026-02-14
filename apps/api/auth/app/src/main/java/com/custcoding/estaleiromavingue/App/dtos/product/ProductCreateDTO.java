package com.custcoding.estaleiromavingue.App.dtos.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductCreateDTO(

    @NotBlank(message = "Product name should not be blank")
    String name,

    @NotBlank(message = "Product description should not be blank")
    String description,

    @NotNull(message = "Price should not be blank")
    @Positive(message = "Price must be positive")
    BigDecimal price

) {
}
