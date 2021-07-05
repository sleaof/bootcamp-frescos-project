package com.mercadolibre.dambetan01.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BatchDTO {

    private Long batchNumber;
    private Long productId;
    private Double currentTemperature;
    private Double minTemperature;
    private int initialQuantity;
    private int currentQuantity;
    private LocalDate manufacturingDate;
    private LocalDate manufacturingTime;
    private LocalDate dueDate;
}
