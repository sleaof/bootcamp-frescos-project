package com.mercadolibre.dambetan01.unit.service;

import com.mercadolibre.dambetan01.dtos.BatchDTO;
import com.mercadolibre.dambetan01.dtos.response.BatchResponseDTO;
import com.mercadolibre.dambetan01.model.*;
import com.mercadolibre.dambetan01.repository.BatchRepository;
import com.mercadolibre.dambetan01.service.crud.impl.BatchServiceImpl;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BatchServiceImplTest {

    BatchRepository repository = Mockito.mock(BatchRepository.class);
    BatchServiceImpl service;

    Batch batch;
    Batch batchNull = null;
    BatchDTO batchDTO;
    List<BatchDTO> listOfBatches = new ArrayList<>();
    List<JSONObject> listOfBatchesJsonObject = new ArrayList<>();

    @BeforeEach
    void setUp() {
        this.service = new BatchServiceImpl(repository, new ModelMapper());

        batch = new Batch(1L, -15.0, -5.0, LocalDate.of(2021, 7, 7), LocalDate.of(2021, 7, 21), 150L, 150L, LocalDate.of(2021, 10, 7), null, null, null, null);
        batchDTO = new BatchDTO(1L, 3L, -5.0, -15.0, 150L, 150L, LocalDate.of(2021, 7, 7), LocalDate.of(2021, 7, 21), LocalDate.of(2021, 10, 7));

        listOfBatches.add(batchDTO);

        JSONObject object = new JSONObject();

        object.put("batchNumber", 3);
        object.put("productId", 3);
        object.put("productType", "REFRIGERATED");
        object.put("quantity", 150);
        object.put("dueDate", "2021-10-07");

        listOfBatchesJsonObject.add(object);

    }

    @Test
    void batch_create_returnObj() {
        BatchDTO batchCreate = service.create(batchDTO);
        verify(repository).save(any());
    }

    @Test
    void batch_update_returnObj() {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(batch));
        BatchDTO batchCreate = service.update(batchDTO);
        verify(repository).save(any());
    }

    @Test
    void batch_delete_returnException() {
        when(repository.findById(100L)).thenReturn(Optional.ofNullable(batchNull));
        assertThrows(NoSuchElementException.class, () -> service.delete(100L),
                "Não foi encontrado nenhum estoque com este Id: 100");
    }

    @Test
    void batch_delete_deletedObj() {
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(batch));
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void batch_findById_returnException() {
        when(repository.findById(100L)).thenReturn(Optional.ofNullable(batchNull));
        assertThrows(NoSuchElementException.class, () -> service.findById(100L),
                "Não foi encontrado nenhum estoque com este Id: 100");
    }

    @Test
    void batch_findById_returnObject() {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(batch));
        BatchDTO batchDTO = service.findById(1L);
        assertEquals(-5.0, batchDTO.getCurrentTemperature());
    }

    @Test
    void batch_findAll_returnList() {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(batch));
        List<BatchDTO> batchDTO = service.findAll();
        assertEquals(-5.0, listOfBatches.get(0).getCurrentTemperature());
    }

    @Test
    void batch_getAllBatchesOffAWarehouseByDueDate_returnList() {
        when(repository.findAllBatchesOffAWarehouseByDueDate(30)).thenReturn(listOfBatchesJsonObject);
        List<BatchResponseDTO> listOfProductsDTO = service.getAllBatchesOffAWarehouseByDueDate(30);
        assertEquals(3, listOfProductsDTO.get(0).getBatchNumber());
    }

    @Test
    void batch_getAllBatchesSortedByDueDateAndCategory_returnList() {
        when(repository.findAllBatchesSortedByDueDateAndCategory(30, "REFRIGERATED")).thenReturn(listOfBatchesJsonObject);
        List<BatchResponseDTO> listOfProductsDTO = service.getAllBatchesSortedByDueDateAndCategory(30, "REFRIGERATED");
        assertEquals(3, listOfProductsDTO.get(0).getBatchNumber());
    }
}
