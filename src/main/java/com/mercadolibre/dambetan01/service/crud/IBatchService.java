package com.mercadolibre.dambetan01.service.crud;

import com.mercadolibre.dambetan01.dtos.BatchDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchResponseDTO;

import java.util.List;

public interface IBatchService extends ICRUD<BatchDTO>{

    List<BatchResponseDTO> getAllBatchesOffAWarehouseByDueDate(Integer days);
    List<BatchResponseDTO> getAllBatchesSortedByDueDateAndCategory(Integer days, String category);
}
