package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchResponseDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.service.BatchService;
import com.mercadolibre.dambetan01.service.crud.IBatchService;
import com.mercadolibre.dambetan01.service.impl.BatServiceImpl;
import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/api/v1")
@RestController
public class BatchController {

    private final BatServiceImpl batchService;
    private final IBatchService iBatchService;

    public BatchController(BatServiceImpl batchService, IBatchService iBatchService) {
        this.batchService = batchService;
        this.iBatchService = iBatchService;
    }

    @PostMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> createInboundOrder(@Valid @RequestBody InboundOrderDTO inboundOrderDTO) {
        return new ResponseEntity<>(batchService.createBatchStock(inboundOrderDTO), HttpStatus.CREATED);
    }

    @PutMapping("/fresh-products/inbounded/")
    public ResponseEntity<BatchStockResponseDTO> updateInboundOrder(@Valid @RequestBody InboundOrderDTO inboundOrderDTO, Long orderNumber) {
        return new ResponseEntity<>(batchService.updateBatchStock(inboundOrderDTO, orderNumber), HttpStatus.CREATED);
    }

    @GetMapping("/fresh-products/due-date/")
    public ResponseEntity<?> getAllBatchesOffAWarehouseByDueDate(@RequestParam("days") Integer days){
        return new ResponseEntity<>(iBatchService.getAllBatchesOffAWarehouseByDueDate(days), HttpStatus.OK);
    }

    @GetMapping("/fresh-products/due-date/list/")
    public ResponseEntity<List<BatchResponseDTO>> getAllBatchesSortedByDueDateAndCategory(@RequestParam("days") Integer days, @RequestParam("category") String category){
        return new ResponseEntity<>(iBatchService.getAllBatchesSortedByDueDateAndCategory(days, category), HttpStatus.OK);
    }
}
