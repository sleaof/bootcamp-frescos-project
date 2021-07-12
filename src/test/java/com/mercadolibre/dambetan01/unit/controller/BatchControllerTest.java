package com.mercadolibre.dambetan01.unit.controller;

import com.mercadolibre.dambetan01.controller.BatchController;
import com.mercadolibre.dambetan01.dtos.response.BatchResponseDTO;
import com.mercadolibre.dambetan01.service.crud.impl.BatchServiceImpl;
import com.mercadolibre.dambetan01.service.impl.BatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

public class BatchControllerTest {

    BatchController controller;
    BatServiceImpl batchService = Mockito.mock(BatServiceImpl.class);
    BatchServiceImpl service = Mockito.mock(BatchServiceImpl.class);

    List<BatchResponseDTO> listOfBatches = new ArrayList<>();

    @BeforeEach
    void setUp() {
        controller = new BatchController(batchService, service);

        listOfBatches.add(new BatchResponseDTO(1L, 1L, "FRESH", 4L, new Date(2021, Calendar.AUGUST, 7)));

    }

    @Test
    void product_getAllBatchesOffAWarehouseByDueDate_returnList() {
        when(service.getAllBatchesOffAWarehouseByDueDate(30)).thenReturn(listOfBatches);
        assertSame(controller.getAllBatchesOffAWarehouseByDueDate(30).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void product_getAllBatchesSortedByDueDateAndCategory_returnList() {
        when(service.getAllBatchesSortedByDueDateAndCategory(30, "FRESH")).thenReturn(listOfBatches);
        assertSame(controller.getAllBatchesSortedByDueDateAndCategory(30, "FRESH").getStatusCode(), HttpStatus.OK);
    }

}
