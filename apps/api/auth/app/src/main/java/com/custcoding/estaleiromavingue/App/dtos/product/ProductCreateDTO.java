package com.custcoding.estaleiromavingue.App.dtos.product;

import java.math.BigDecimal;

public record ProductCreateDTO(
    String name,
    String description,
    BigDecimal price

) {
}
