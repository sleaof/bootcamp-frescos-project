package com.mercadolibre.dambetan01.service;

import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import org.json.simple.JSONObject;

import java.util.List;

public interface BatchService {

    Batch findBatchByBatchNumber(Long batchNumber);

    BatchStockResponseDTO createBatchStock(InboundOrderDTO inboundOrderDTO) throws Throwable;

    BatchStockResponseDTO updateBatchStock(InboundOrderDTO inboundOrderDTO, Long orderNumber);

    List<JSONObject> checkProductsLocationInWarehouse(Long productId, String orderType, Long warehouseId);

}
