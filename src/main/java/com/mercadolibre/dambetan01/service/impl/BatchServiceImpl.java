package com.mercadolibre.dambetan01.service.impl;

import com.mercadolibre.dambetan01.dtos.BatchDTO;
import com.mercadolibre.dambetan01.dtos.InboundOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.dambetan01.model.Batch;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.model.Section;
import com.mercadolibre.dambetan01.model.Warehouse;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.service.BatchService;
import com.mercadolibre.dambetan01.service.ProductService;
import com.mercadolibre.dambetan01.service.SectionService;
import com.mercadolibre.dambetan01.service.WarehouseService;
import lombok.AllArgsConstructor;
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

    @Override
    public BatchStockResponseDTO createBatchStock(InboundOrderDTO inboundOrderDTO) {

        BatchStockResponseDTO batchStockResponseDTO = new BatchStockResponseDTO();
        List<Batch> batchStock = new ArrayList<>();
        Section section = buildSection(inboundOrderDTO);

        for(BatchDTO b : inboundOrderDTO.getBatchStock()){
            Product product = productService.findById(b.getProductId());
            Batch batch = newBatch(b);
            batch.setProduct(product);
            batch.setSection(section);
            batchStock.add(batch);
            batchRepository.save(batch);
        }

        batchStockResponseDTO.setBatchStock(batchStock);
        return batchStockResponseDTO;
    }


    //Retirar do Service----
    private Batch newBatch(BatchDTO b){

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

    //Retirar do Service
    private Section buildSection(InboundOrderDTO inboundOrderDTO) {

        Section section = sectionService.findById(inboundOrderDTO.getSection().getSectionCode());
        Warehouse warehouse = warehouseService.findById(inboundOrderDTO.getSection().getWarehouseCode());
        section.setWarehouse(warehouse);

        return section;
    }
}
