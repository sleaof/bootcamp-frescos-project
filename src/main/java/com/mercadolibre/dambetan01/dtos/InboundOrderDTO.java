package com.mercadolibre.dambetan01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderDTO {

    private Long orderNumber;
    private LocalDate orderDate;
    private SectionDTO section;
    private List<BatchDTO> batchStock;


}
