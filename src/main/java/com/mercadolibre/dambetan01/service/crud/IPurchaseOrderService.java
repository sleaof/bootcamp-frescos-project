package com.mercadolibre.dambetan01.service.crud;

import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.dtos.PurchaseOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.dtos.response.TotalPriceResponseDTO;
import net.sf.json.JSONObject;

import java.util.List;

public interface IPurchaseOrderService extends ICRUD<PurchaseOrderDTO>{

    List<ProductResponseDTO> findProductsByOrderId(Long id);

    TotalPriceResponseDTO calcTotalValue(PurchaseOrderDTO purchaseOrderDTO);
}
