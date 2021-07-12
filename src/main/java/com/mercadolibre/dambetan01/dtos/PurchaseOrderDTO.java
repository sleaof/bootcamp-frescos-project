package com.mercadolibre.dambetan01.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mercadolibre.dambetan01.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Validated
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDTO {

    @JsonIgnore
    private Long purchaseOrderId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull(message = "Deve conter o status do pedido de compra")
    private OrderStatus orderStatus;

    @NotNull(message = "Deve conter o id de comprador")
    private Long buyer;

    @Valid
    private List<ProductBatchOrderDTO> products;
}
