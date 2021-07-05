package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.service.BatchService;
import com.mercadolibre.dambetan01.service.InboudOrderService;
import org.springframework.stereotype.Service;


@Service
public class InboudOrderServiceImpl implements InboudOrderService {


    private final BatchService batchService;

    public InboudOrderServiceImpl(BatchService batchService) {
        this.batchService = batchService;
    }

    public BatchStockResponseDTO createInboundOrder(InboundOrderDTO inboundOrderDTO){
        return batchService.createBatchStock(inboundOrderDTO);
    }
}
