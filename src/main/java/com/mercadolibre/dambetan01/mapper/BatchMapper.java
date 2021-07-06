package com.mercadolibre.dambetan01.mapper;

import com.mercadolibre.dambetan01.dtos.BatchDTO;
import com.mercadolibre.dambetan01.model.Batch;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BatchMapper {

    public static Batch newBatch(BatchDTO b){
        Batch batch = new Batch();
        batch.setMinTemperature(b.getMinTemperature());
        batch.setCurrentTemperature(b.getCurrentTemperature());
        batch.setManufacturingDate(b.getManufacturingDate());
        batch.setManufacturingTime(b.getManufacturingTime());
        batch.setInitialQuantity(b.getInitialQuantity());
        batch.setCurrentQuantity(b.getCurrentQuantity());
        batch.setDueDate(b.getDueDate());
        return batch;
    }

    public static Batch updateBatch(BatchDTO b, Batch batch){
        batch.setMinTemperature(b.getMinTemperature());
        batch.setCurrentTemperature(b.getCurrentTemperature());
        batch.setManufacturingDate(b.getManufacturingDate());
        batch.setManufacturingTime(b.getManufacturingTime());
        batch.setInitialQuantity(b.getInitialQuantity());
        batch.setCurrentQuantity(b.getCurrentQuantity());
        batch.setDueDate(b.getDueDate());
        return batch;
    }

    public static BatchDTO convertBatchToBatchDTO(Batch batch) {
        return BatchDTO.builder()
                .batchNumber(batch.getBatchId())
                .productId(batch.getProduct().getProductId())
                .currentTemperature(batch.getCurrentTemperature())
                .minTemperature(batch.getMinTemperature())
                .initialQuantity(batch.getInitialQuantity())
                .currentQuantity(batch.getCurrentQuantity())
                .manufacturingDate(batch.getManufacturingDate())
                .manufacturingTime(batch.getManufacturingTime())
                .dueDate(batch.getDueDate())
                .build();
    }

}
