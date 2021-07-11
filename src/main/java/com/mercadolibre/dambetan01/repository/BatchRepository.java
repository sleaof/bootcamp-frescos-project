package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.Batch;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query(value = "select * from view_product_batch_in_warehouse " +
            "WHERE dueDate >= date(now()) + interval :days day", nativeQuery = true)
    List<JSONObject> findAllBatchesOffAWarehouseByDueDate(@Param("days") Integer days);

    @Query(value = "select * from view_product_batch_in_warehouse " +
            "WHERE dueDate >= date(now()) + interval :days day AND productType= :category  " +
            "ORDER BY dueDate ASC", nativeQuery = true)
    List<JSONObject> findAllBatchesSortedByDueDateAndCategory(@Param("days") Integer days, @Param("category") String category);
}
