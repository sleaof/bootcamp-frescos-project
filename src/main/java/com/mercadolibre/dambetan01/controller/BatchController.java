package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.service.impl.BatchServiceImpl;
import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RequestMapping(path = "/api/v1")
@RestController
public class BatchController {

    private BatchServiceImpl batchService;

    @PostMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> createInboundOrder(@Valid @RequestBody  InboundOrderDTO inboundOrderDTO) throws Throwable {
        return new ResponseEntity<>(batchService.createBatchStock(inboundOrderDTO), HttpStatus.CREATED);
    }

    @PutMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> updateInboundOrder(@Valid @RequestBody InboundOrderDTO inboundOrderDTO, Long orderNumber){
        return new ResponseEntity<>(batchService.updateBatchStock(inboundOrderDTO, orderNumber), HttpStatus.CREATED);
    }

    @GetMapping("/fresh-products/list")
    public List<JSONObject> checkProductsLocationInWarehouse(@RequestParam("productId") Long productId, @RequestParam("orderType") String orderType, @RequestParam("warehouseId") Long warehouseId) {
        return batchService.checkProductsLocationInWarehouse(productId, orderType, warehouseId);
    }

}
