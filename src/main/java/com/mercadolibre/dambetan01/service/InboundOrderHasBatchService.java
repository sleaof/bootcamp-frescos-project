package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.InboundOrder;

public interface InboundOrderHasBatchService {

    void createInboundOrderHasBatch(InboundOrder inboundOrder, Batch batch);

}
