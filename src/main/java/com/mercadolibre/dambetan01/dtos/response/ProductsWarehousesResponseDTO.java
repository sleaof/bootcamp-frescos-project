package com.mercadolibre.dambetan01.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsWarehousesResponseDTO {

    private Long productId;
    private List<JSONObject> warehouses;

}
