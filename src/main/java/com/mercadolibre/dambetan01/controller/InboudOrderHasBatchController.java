package com.mercadolibre.dambetan01.controller;


import com.mercadolibre.dambetan01.dtos.response.InboundOrderHasBatchResponseDTO;
import com.mercadolibre.dambetan01.model.InboundOrderHasBatch;
import com.mercadolibre.dambetan01.service.InboundOrderHasBatchService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class InboudOrderHasBatchController {

    private InboundOrderHasBatchService inboundOrderHasBatchService;

    @GetMapping("/inboudOrderHasBatchOnDate")
    public ResponseEntity<List<InboundOrderHasBatch>> findInboundOrdersOnDate(@RequestParam("firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate firstDate
            ,@RequestParam("secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate secondDate){
        List<InboundOrderHasBatch> inbound = inboundOrderHasBatchService.findInboudOrderHasBatchOnDate(firstDate,secondDate);
        return new ResponseEntity<>(inbound, HttpStatus.OK);
    }

    @GetMapping("/inboudOrderHasBatchOnDateDTO")
    public ResponseEntity<List<InboundOrderHasBatchResponseDTO>> findInboundBetween(@RequestParam("firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate firstDate
            , @RequestParam("secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate secondDate){
        List<InboundOrderHasBatchResponseDTO> inbound = inboundOrderHasBatchService.findInboundOrderBetweenDate(firstDate,secondDate);
        return new ResponseEntity<>(inbound, HttpStatus.OK);
    }

}
