package com.mercadolibre.dambetan01.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDTO {
    private Long batchNumber;
    private Long productId;
    private Double currentTemperature;
    private Double minTemperature;
    private Long initialQuantity;
    private Long currentQuantity;
    private LocalDate manufacturingDate;
    private LocalDate manufacturingTime;
    private LocalDate dueDate;
}
