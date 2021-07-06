package com.mercadolibre.dambetan01.service.crud;

import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.dtos.PurchaseOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import net.sf.json.JSONObject;

import java.util.List;

public interface IPurchaseOrderService extends ICRUD<PurchaseOrderDTO>{

    List<ProductResponseDTO> selectProductsFromOrderId(Long id);

    Float calcTotalValue(List<ProductDTO> product);
}
