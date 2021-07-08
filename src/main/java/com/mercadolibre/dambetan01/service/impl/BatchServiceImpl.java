package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.BatchDTO;
import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.exceptions.NotFoundException;
import com.mercadolibre.dambetan01.mapper.BatchMapper;
import com.mercadolibre.dambetan01.model.*;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.service.*;
import lombok.AllArgsConstructor;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;
    private final ProductService productService;
    private final WarehouseService warehouseService;
    private final SectionService sectionService;
    private final InboundOrderService inboundOrderService;
    private final InboundOrderHasBatchService inboundOrderHasBatchService;

    @Override
    public Batch findBatchByBatchNumber(Long batchNumber) {
        return batchRepository.findById(batchNumber).orElseThrow(() -> new NotFoundException("Batch " + batchNumber));
    }

    @Override
    public BatchStockResponseDTO createBatchStock(InboundOrderDTO inboundOrderDTO) {
        BatchStockResponseDTO batchStockResponseDTO = new BatchStockResponseDTO();
        List<BatchDTO> batchStock = new ArrayList<>();
        Section section = buildSectionToBatchStock(inboundOrderDTO);
        InboundOrder inboundOrder = inboundOrderService.createInboundOrder(inboundOrderDTO);
        for(BatchDTO b : inboundOrderDTO.getBatchStock()){
                Product product = productService.findById(b.getProductId());
                Batch batch = BatchMapper.newBatch(b);
                batch.setProduct(product);
                batch.setSection(section);
                batchRepository.save(batch);
                inboundOrderHasBatchService.createInboundOrderHasBatch(inboundOrder, batch);
                batchStock.add(BatchMapper.convertBatchToBatchDTO(batch));
        }
        batchStockResponseDTO.setBatchStock(batchStock);
        return batchStockResponseDTO;
    }

    @Override
    public BatchStockResponseDTO updateBatchStock(InboundOrderDTO inboundOrderDTO, Long orderNumber) {
        BatchStockResponseDTO batchStockResponseDTO = new BatchStockResponseDTO();
        List<BatchDTO> batchStock = new ArrayList<>();
        Section section = buildSectionToBatchStock(inboundOrderDTO);
        for(BatchDTO b : inboundOrderDTO.getBatchStock()){
                Batch updateBatch = findBatchByBatchNumber(b.getBatchNumber());
                updateBatch = BatchMapper.updateBatch(b, updateBatch);
                updateBatch.setSection(section);
                batchRepository.save(updateBatch);
                batchStock.add(BatchMapper.convertBatchToBatchDTO(updateBatch));
                batchStockResponseDTO.setBatchStock(batchStock);
        }
        return batchStockResponseDTO;
    }

    @Override
    public List<JSONObject> checkProductsLocationInWarehouse(Long productId, String orderType, Long warehouseId){

            List<JSONObject> query = batchRepository.checkProductsLocationInWarehouse(productId, warehouseId);
            return query;
    }

    public Section buildSectionToBatchStock(InboundOrderDTO inboundOrderDTO) {
        Section section = sectionService.findById(inboundOrderDTO.getSection().getSectionCode());
        Warehouse warehouse = warehouseService.findById(inboundOrderDTO.getSection().getWarehouseCode());
        section.setWarehouse(warehouse);
        return section;
    }

}
