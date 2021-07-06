package com.mercadolibre.dambetan01.dtos.response;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private Integer quantity;
}
