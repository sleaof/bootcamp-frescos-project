package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.PurchaseOrder;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    @Query(value = "SELECT productId, productName, quantity FROM view_products_from_order_by_id " +
            "WHERE purchase_order_id = :orderId", nativeQuery = true)
    List<JSONObject> findProductsFromOrderById(@Param("orderId") Long orderId);
}
