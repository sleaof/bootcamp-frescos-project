package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.model.InboundOrder;

public interface InboundOrderService {

    InboundOrder findById(Long id);

    InboundOrder createInboundOrder(InboundOrderDTO inboundOrderDTO);

}
