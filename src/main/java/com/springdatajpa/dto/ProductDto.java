package com.springdatajpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    @NotBlank(message = "user name cant null")
    private String name;
    @NotBlank(message = "pls provide the proper product description")
    private String description;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdated;
}
