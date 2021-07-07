package com.mercadolibre.dambetan01.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchHasPurchaseOrderDTO {

    @JsonIgnore
    private Long batchHasPurchaseOrderId;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "PurchaseOrder id is required")
    private Long purchaseOrderId;

    @NotNull(message = "Batch id is required")
    private Long batchId;
}
