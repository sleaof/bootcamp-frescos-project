package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.response.InboundOrderHasBatchResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.InboundOrder;
import com.mercadolibre.dambetan01.model.InboundOrderHasBatch;
import com.mercadolibre.dambetan01.repository.InboundOrderHasBatchRepository;
import com.mercadolibre.dambetan01.service.InboundOrderHasBatchService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InboundOrderHasBatchServiceImpl implements InboundOrderHasBatchService {

    private final InboundOrderHasBatchRepository orderHasBatchRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createInboundOrderHasBatch(InboundOrder inboundOrder, Batch batch){
        InboundOrderHasBatch inboundOrderHasBatch = new InboundOrderHasBatch();
        inboundOrderHasBatch.setInboundOrder(inboundOrder);
        inboundOrderHasBatch.setBatchs(batch);
        inboundOrderHasBatch.setQuantity(batch.getInitialQuantity());
        orderHasBatchRepository.save(inboundOrderHasBatch);
    }

    @Override
    public List<InboundOrderHasBatchResponseDTO> findInboundOrderBetweenDate(LocalDate firstDate, LocalDate secondDate) {
        return orderHasBatchRepository.findInboundOrderDate(firstDate,secondDate)
                .stream()
                .map(inboundOrderHasBatch -> modelMapper.map(inboundOrderHasBatch, InboundOrderHasBatchResponseDTO.class))
                .collect(Collectors.toList());
    }
}
