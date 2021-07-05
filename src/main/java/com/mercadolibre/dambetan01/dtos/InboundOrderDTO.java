package com.mercadolibre.dambetan01.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InboundOrderDTO {

    private Long orderNumber;
    private LocalDate orderDate;
    private SectionDTO section;
    private List<BatchDTO> batchStock;


}
