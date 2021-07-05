package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.service.BatchService;
import com.mercadolibre.dambetan01.service.InboudOrderService;
import com.mercadolibre.dambetan01.service.impl.InboudOrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping(path = "/api/v1")
@RestController
public class InboundOrderController {

    private InboudOrderServiceImpl inboudOrderService;

    @PostMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> createBatchStock(@RequestBody InboundOrderDTO inboundOrderDTO){
        return new ResponseEntity<>(inboudOrderService.createInboundOrder(inboundOrderDTO), HttpStatus.CREATED);
    }

    @PutMapping("/fresh-products/inbounded/")
    public String upadateInboundOrder(){
        return "Atualizou os lotes";
    }
}
