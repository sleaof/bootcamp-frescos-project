package com.mercadolibre.dambetan01.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mercadolibre.dambetan01.enums.ProductCategory;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Validated
@Data
public class ProductDTO {

    @JsonIgnore
    @NotNull(message = "Product id is required")
    private Long productId;

    @NotNull(message = "Product name is required")
    private String productName;

    @JsonIgnore
    @NotNull(message = "Product temperature is required")
    private Double temperature;

    @JsonIgnore
    @NotNull(message = "Product validated is required")
    private LocalDate validated;

    @NotNull(message = "Product price is required")
    private Float price;

    @NotNull(message = "Product category is required")
    private ProductCategory productCategory;
}
