package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.dtos.response.InboundOrderHasBatchResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.InboundOrder;
import com.mercadolibre.dambetan01.model.InboundOrderHasBatch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface InboundOrderHasBatchService {

    void createInboundOrderHasBatch(InboundOrder inboundOrder, Batch batch);

    //List<InboundOrderHasBatch> findInboudOrderHasBatchOnDate(LocalDate firstDate, LocalDate secondDate);

    List<InboundOrderHasBatchResponseDTO> findInboundOrderBetweenDate(LocalDate firstDate, LocalDate secondDate);
}
