package com.mercadolibre.dambetan01.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatchOrderDTO {

    private Long productId;

    @NotNull(message = "Deve ser informada a quantidade.")
    @Range(min = 0, message = "Deve ser informado um valor positivo")
    private Integer quantity;
}
