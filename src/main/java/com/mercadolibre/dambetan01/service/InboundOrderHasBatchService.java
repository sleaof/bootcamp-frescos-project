package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.dtos.response.InboundOrderHasBatchResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.InboundOrder;
import java.time.LocalDate;
import java.util.List;

public interface InboundOrderHasBatchService {

    void createInboundOrderHasBatch(InboundOrder inboundOrder, Batch batch);

    List<InboundOrderHasBatchResponseDTO> findInboundOrderBetweenDate(LocalDate firstDate, LocalDate secondDate);
}
