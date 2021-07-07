package com.mercadolibre.dambetan01.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatchOrderDTO {

    @NotNull(message = "Product id is required")
    private Long productId;

    @NotNull(message = "Product quantity is required")
    private Integer quantity;
}
