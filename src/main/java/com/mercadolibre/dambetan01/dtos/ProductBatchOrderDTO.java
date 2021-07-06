package com.mercadolibre.dambetan01.dtos;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Data
public class ProductBatchOrderDTO {

    @NotNull(message = "Product id is required")
    private Long productId;

    @NotNull(message = "Product quantity is required")
    private Integer quantity;
}
