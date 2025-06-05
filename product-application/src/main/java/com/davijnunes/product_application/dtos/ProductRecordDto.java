package com.davijnunes.product_application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRecordDto(
    
    @NotBlank(message = "Nome não pode estar em branco")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    String productName,

    @NotBlank(message = "Descrição não pode estar em branco")
    String productDescription,
    
    @Positive(message = "Preço deve ser positivo")
    Double productPrice
    
) {}