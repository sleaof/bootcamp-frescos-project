package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.mapper.InboundOrderMapper;
import com.mercadolibre.dambetan01.model.InboundOrder;
import com.mercadolibre.dambetan01.repository.InboundOrderRepository;
import com.mercadolibre.dambetan01.service.InboundOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InboundOrderServiceImpl implements InboundOrderService {

    private InboundOrderRepository inboundOrderRepository;

    @Override
    public InboundOrder findById(Long id) {
        return inboundOrderRepository.findById(id).orElseThrow();
    }

    @Override
    public InboundOrder createInboundOrder(InboundOrderDTO inboundOrderDTO){
        InboundOrder inboundOrder = InboundOrderMapper.convertInboundOrderDtoToInboundOrder(inboundOrderDTO);
        return inboundOrderRepository.save(inboundOrder);
    }

}
