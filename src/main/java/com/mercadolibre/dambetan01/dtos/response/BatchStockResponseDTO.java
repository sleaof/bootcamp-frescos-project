package com.mercadolibre.dambetan01.dtos.response;

import com.mercadolibre.dambetan01.model.Batch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockResponseDTO {

    private List<Batch> batchStock;
}
