package com.mercadolibre.dambetan01.dtos.response;

import com.mercadolibre.dambetan01.enums.ProductCategory;
import lombok.Data;

@Data
public class ProductResponseDTO {

    private Long productId;
    private String productName;
    private Double temperature;
    private Float price;
    private ProductCategory productCategory;
}
