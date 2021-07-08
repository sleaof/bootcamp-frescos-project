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
public class SectionDTO {

    @NotNull(message = "O código da seção deve ser informada.")
    private Long sectionCode;

    @NotNull(message = "O código da warehouse deve ser informada.")
    private Long warehouseCode;
}
