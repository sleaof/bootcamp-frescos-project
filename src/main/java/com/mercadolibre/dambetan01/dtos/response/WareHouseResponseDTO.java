package com.mercadolibre.dambetan01.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WareHouseResponseDTO {

    private Long warehousesCode;
    private Long totalQuantity;

}
