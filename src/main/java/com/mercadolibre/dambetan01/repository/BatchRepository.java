package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.Batch;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Modifying
    @Transactional
    @Query(value = "select section_id_fk as sectionCode , warehouse_id_fk as warehouseCode, product_id_fk as productId," +
            "batch_id as batchNumber, current_quantity as currentQuantity, due_date as dueDate from view_product_batch_in_warehouse " +
            "where product_id_fk = :productId and warehouse_id_fk = :warehouseId " +
            "order by current_quantity ", nativeQuery = true)
    List<JSONObject> checkProductsLocationInWarehouse(@Param("productId")Long productId, @Param("warehouseId") Long warehouseId);



}
