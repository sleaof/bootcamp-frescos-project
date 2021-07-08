package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.Batch;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query(value = "SELECT B.batch_id AS batchNumber, B.product_id_fk AS productId, P.product_category AS productType, B.current_quantity AS quantity, B.due_date AS dueDate " +
            "FROM batch AS B " +
            "INNER JOIN products AS P ON B.product_id_fk = P.product_id " +
            "INNER JOIN sections AS S ON B.section_id_fk = S.section_id " +
            "WHERE due_date >= date(now()) + interval :days day", nativeQuery = true)
    List<JSONObject> findAllBatchesOffAWarehouseByDueDate(@Param("days") Integer days);

    @Query(value = "SELECT B.batch_id AS batchNumber, B.product_id_fk AS productId, P.product_category AS productType, B.current_quantity AS quantity, B.due_date AS dueDate " +
            "FROM batch AS B " +
            "INNER JOIN products AS P ON B.product_id_fk = P.product_id " +
            "INNER JOIN sections AS S ON B.section_id_fk = S.section_id " +
            "WHERE due_date >= date(now()) + interval :days day AND P.product_category = :category " +
            "ORDER BY due_date ASC", nativeQuery = true)
    List<JSONObject> findAllBatchesSortedByDueDateAndCategory(@Param("days") Integer days, @Param("category") String category);
}
