package com.mercadolibre.dambetan01.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchResponseDTO {

    private Long batchNumber;
    private Long productId;
    private String productType;
    private Long quantity;
    private Date dueDate;
}
