package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/v1")
@RestController
public class InboundOrderController {

    @PostMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> createBatchStock(@RequestBody InboundOrderDTO inboundOrderDTO){
        //BatchStockResponseDTO;
        return null;

    }

    @PutMapping("/fresh-products/inbounded/")
    public String upadateInboundOrder(){
        return "Atualizou os lotes";
    }
}
