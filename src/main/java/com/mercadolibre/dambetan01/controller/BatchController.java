package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.service.impl.BatServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RequestMapping(path = "/api/v1")
@RestController
public class BatchController {

    private final BatServiceImpl batchService;

    @PostMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> createInboundOrder(@Valid @RequestBody InboundOrderDTO inboundOrderDTO) {
        return new ResponseEntity<>(batchService.createBatchStock(inboundOrderDTO), HttpStatus.CREATED);
    }

    @PutMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> updateInboundOrder(@Valid @RequestBody InboundOrderDTO inboundOrderDTO, Long orderNumber) {
        return new ResponseEntity<>(batchService.updateBatchStock(inboundOrderDTO, orderNumber), HttpStatus.CREATED);
    }
}
