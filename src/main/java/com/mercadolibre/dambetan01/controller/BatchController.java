package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.model.InboundOrder;
import com.mercadolibre.dambetan01.service.impl.BatchServiceImpl;
import com.mercadolibre.dambetan01.service.impl.InboundOrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping(path = "/api/v1")
@RestController
public class BatchController {

    private BatchServiceImpl batchService;

    @PostMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> createInboundOrder(@RequestBody  InboundOrderDTO inboundOrderDTO){
        return new ResponseEntity<>(batchService.createBatchStock(inboundOrderDTO), HttpStatus.CREATED);
    }

    @PutMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> updateInboundOrder(@RequestBody InboundOrderDTO inboundOrderDTO, Long orderNumber){
        return new ResponseEntity<>(batchService.updateBatchStock(inboundOrderDTO, orderNumber), HttpStatus.CREATED);
    }
}
