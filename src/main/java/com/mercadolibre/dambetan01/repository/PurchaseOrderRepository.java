package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.PurchaseOrder;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    @Query(value = "select p.product_id as productId, p.product_name as productName, bp.quantity as quantity " +
            "from products as p " +
            "inner join batch as b on p.product_id = b.product_id_fk " +
            "inner join batch_has_purchase_orders as bp on b.batch_id = bp.batch_id " +
            "inner join purchase_orders as po on bp.purchase_order_id = po.purchase_order_id where po.purchase_order_id = :orderId", nativeQuery = true)
    List<JSONObject> findProductsFromOrderById(@Param("orderId") Long orderId);

}
