package com.mercadolibre.dambetan01.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mercadolibre.dambetan01.enums.OrderStatus;
import com.mercadolibre.dambetan01.model.Buyer;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Validated
@Data
public class PurchaseOrderDTO {

    @JsonIgnore
    private Long purchaseOrderId;

    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Order status is required")
    private OrderStatus orderStatus;

    @NotNull(message = "Buyer Id is required")
    private Buyer buyer;

    @Valid
    private List<ProductDTO> products;
}
