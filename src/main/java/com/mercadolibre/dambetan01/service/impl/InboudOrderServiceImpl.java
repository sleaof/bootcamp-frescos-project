package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.service.BatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InboudOrderServiceImpl {

    private final BatchService batchService;

    public BatchStockResponseDTO createInboundOrder(InboundOrderDTO inboundOrderDTO){
        return batchService.createBatchStock(inboundOrderDTO);
    }
}
