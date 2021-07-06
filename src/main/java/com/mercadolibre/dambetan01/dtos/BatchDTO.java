package com.mercadolibre.dambetan01.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDTO {

    private Long batchNumber;

    @NotNull(message = "Produto não pode ser nulo")
    private Long productId;

    @NotNull(message = "Deve ser informada a temperatura atual.")
    private Double currentTemperature;

    @NotNull(message = "Deve ser informada a temperatura mínima.")
    private Double minTemperature;

    @NotNull(message = "Deve conter a quantidade inicial.")
    @Range(min = 0, message = "Deve ser informado um valor positivo")
    private Long initialQuantity;

    @NotNull(message = "Deve conter a quantidade atual.")
    @Range(min = 0, message = "Deve ser informado um valor positivo")
    private Long currentQuantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate  manufacturingDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate  manufacturingTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate  dueDate;
}
