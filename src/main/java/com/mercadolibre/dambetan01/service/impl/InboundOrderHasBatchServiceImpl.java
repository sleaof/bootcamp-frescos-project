package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.InboundOrder;
import com.mercadolibre.dambetan01.model.InboundOrderHasBatch;
import com.mercadolibre.dambetan01.repository.InboundOrderHasBatchRepository;
import com.mercadolibre.dambetan01.service.InboundOrderHasBatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InboundOrderHasBatchServiceImpl implements InboundOrderHasBatchService {

    private final InboundOrderHasBatchRepository orderHasBatchRepository;

    @Override
    public void createInboundOrderHasBatch(InboundOrder inboundOrder, Batch batch){
        InboundOrderHasBatch inboundOrderHasBatch = new InboundOrderHasBatch();
        inboundOrderHasBatch.setInboundOrder(inboundOrder);
        inboundOrderHasBatch.setBatchs(batch);
        inboundOrderHasBatch.setQuantity(batch.getInitialQuantity());
        orderHasBatchRepository.save(inboundOrderHasBatch);
    }
}
