package com.mercadolibre.dambetan01.mapper;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.model.InboundOrder;

public class InboundOrderMapper {

    public static InboundOrder convertInboundOrderDtoToInboundOrder(InboundOrderDTO inboundOrderDTO) {
        return InboundOrder.builder()
                .inboundOrderId(inboundOrderDTO.getOrderNumber())
                .orderDate(inboundOrderDTO.getOrderDate())
                .build();
    }

}
