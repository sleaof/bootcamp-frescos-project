package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.Batch;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query(value = "SELECT * FROM view_product_batch_in_warehouse " +
            "WHERE due_date >= date(now()) + interval :days day", nativeQuery = true)
    List<JSONObject> getAllBatchesOffAWarehouseByDueDate(@Param("days") Integer days);

    @Query(value = "SELECT * FROM view_product_batch_in_warehouse " +
            "WHERE due_date < date(now()) + interval 500 day AND product_category = 'FROZEN' " +
            "ORDER BY due_date ASC", nativeQuery = true)
    List<JSONObject> getAllBatchesSortedByDueDateAndCategory(@Param("days") Integer days, @Param("category") Integer category);
}
