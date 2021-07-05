package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import org.springframework.stereotype.Service;


public interface InboudOrderService {

    BatchStockResponseDTO createInboundOrder(InboundOrderDTO inboundOrderDTO);
}
