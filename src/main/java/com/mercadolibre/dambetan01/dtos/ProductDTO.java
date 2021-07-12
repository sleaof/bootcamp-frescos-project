package com.mercadolibre.dambetan01.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mercadolibre.dambetan01.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Validated
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @JsonIgnore
    private Long productId;

    @NotNull(message = "O nome do produto deve ser informada.")
    private String productName;

    @JsonIgnore
    @NotNull(message = "Deve ser informada a temperatura.")
    private Double temperature;

    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validated;

    @NotNull(message = "Deve conter o preço.")
    @Range(min = 0, message = "Deve ser informado um valor positivo")
    private Float price;

    @NotNull(message = "Deve conter a categoria de produto")
    private ProductCategory productCategory;
}
