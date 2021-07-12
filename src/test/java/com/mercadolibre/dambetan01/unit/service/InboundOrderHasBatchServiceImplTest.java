package com.mercadolibre.dambetan01.unit.service;

import com.mercadolibre.dambetan01.dtos.response.InboundOrderHasBatchResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.InboundOrder;
import com.mercadolibre.dambetan01.model.InboundOrderHasBatch;
import com.mercadolibre.dambetan01.repository.InboundOrderHasBatchRepository;
import com.mercadolibre.dambetan01.service.impl.InboundOrderHasBatchServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

import static org.mockito.Mockito.when;

public class InboundOrderHasBatchServiceImplTest  {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    InboundOrderHasBatchRepository repository = Mockito.mock(InboundOrderHasBatchRepository.class);
    InboundOrderHasBatchServiceImpl service;

    Batch batch;
    InboundOrder inboundOrder;
    InboundOrderHasBatch inboundOrderHasBatch;
    LocalDate firstDate = LocalDate.parse("2020/05/07", dtf);
    LocalDate secondDate = LocalDate.parse("2022/06/07", dtf);
    List<InboundOrderHasBatchResponseDTO> listOfInboundOrderHasBatchResponseDTO = new ArrayList<>();
    List<InboundOrderHasBatch> listOfInboundOrder = new ArrayList<>();

    @BeforeEach
    void setUp(){
        this.service = new InboundOrderHasBatchServiceImpl(repository, new ModelMapper());

        inboundOrder = new InboundOrder(1L, LocalDate.of(2021, 5, 8),listOfInboundOrder,null);
        batch = new Batch(1L, -15.0, -5.0, LocalDate.of(2021, 7, 7), LocalDate.of(2021, 7, 21), 150L, 150L, LocalDate.of(2021, 10, 7), null, null, null, null);
        inboundOrderHasBatch = new InboundOrderHasBatch(1L,30L ,inboundOrder,batch);
        listOfInboundOrder.add(inboundOrderHasBatch);

    }

    @Test
    void inboundOrderHasBatch_Between_Date_returnList(){
        when(repository.findInboundOrderDate(firstDate,secondDate)).thenReturn(listOfInboundOrder);
        listOfInboundOrderHasBatchResponseDTO  = service.findInboundOrderBetweenDate(firstDate,secondDate);
        Assert.assertEquals(Long.valueOf(30), listOfInboundOrderHasBatchResponseDTO.get(0).getQuantity());

    }







}
