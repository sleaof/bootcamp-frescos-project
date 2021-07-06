package com.mercadolibre.dambetan01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDTO {

    @NotNull(message = "O código da seção deve ser informada.")
    private Long sectionCode;

    @NotNull(message = "O código da warehouse deve ser informada.")
    private Long warehouseCode;

}
