package com.mercadolibre.dambetan01.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InbounderOrderResponseDTO {

    private Long inboundOrderId;
    private LocalDate orderDate;
}
