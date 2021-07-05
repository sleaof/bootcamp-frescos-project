package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;

public interface BatchService {

    public BatchStockResponseDTO createBatchStock(InboundOrderDTO inboundOrderDTO);

}
