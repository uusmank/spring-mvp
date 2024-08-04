package com.saee.lynk.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Product (
        @Id
        Integer id,
        @NotBlank
        String name,
        Float price,
        Float weight,
        Integer quantity,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt){

}
