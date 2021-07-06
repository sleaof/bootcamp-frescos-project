package com.mercadolibre.dambetan01.dtos.response;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Integer quantity;
    private Long productId;
    private String productName;
}
