package com.mercadolibre.dambetan01.service.crud;

import com.mercadolibre.dambetan01.dtos.CountryHouseDTO;
import com.mercadolibre.dambetan01.dtos.ProductDTO;
import com.mercadolibre.dambetan01.dtos.PurchaseOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.model.PurchaseOrder;
import org.json.simple.JSONObject;

import java.util.List;

public interface IPurchaseOrderService extends ICRUD<PurchaseOrderDTO>{

    List<JSONObject> selectProductsFromOrderId(Long id);

    Float calcTotalValue(List<ProductDTO> product);
}
