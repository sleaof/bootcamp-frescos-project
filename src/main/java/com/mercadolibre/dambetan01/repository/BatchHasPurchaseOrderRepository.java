package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.BatchHasPurchaseOrder;
import com.mercadolibre.dambetan01.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchHasPurchaseOrderRepository extends JpaRepository<BatchHasPurchaseOrder, Long> {
    @Query(value = "select * from batch_has_purchase_orders where purchase_order_id_fk = :id", nativeQuery = true)
    List<BatchHasPurchaseOrder> findByPurchaseOrderId(@Param("id") Long id);
}
