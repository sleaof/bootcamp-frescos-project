package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.Batch;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query(value = "Select warehouse_id, sum(current_quantity) FROM view_warehouse_product_totalQnty where product_id = :productId GROUP BY warehouse_id;", nativeQuery = true)
    List<JSONObject> productIdFromWarehouses(@Param("productId") Long productId);
}
