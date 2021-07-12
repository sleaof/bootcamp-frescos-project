package com.mercadolibre.dambetan01.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderHasBatchResponseDTO {


    private Long inboundOrderHasBatchId;
    private Long quantity;
    private InbounderOrderResponseDTO inboundOrder;
    private BatchResponseDTO batch;
}
