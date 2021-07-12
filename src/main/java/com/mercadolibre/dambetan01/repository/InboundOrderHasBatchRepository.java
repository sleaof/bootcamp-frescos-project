package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.InboundOrderHasBatch;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface InboundOrderHasBatchRepository extends JpaRepository<InboundOrderHasBatch, Long> {

    @Query(value = "SELECT A.inbound_order_has_batch_id, A.quantity, A.batch_id_fk, A.inbound_order_id_fk " +
            "FROM inbound_order_has_batch AS A INNER JOIN inbound_order AS B " +
            "ON A.inbound_order_id_fk = B.inbound_order_id " +
            "WHERE B.order_date BETWEEN :firstDate AND :secondDate", nativeQuery = true)
    List<InboundOrderHasBatch> findInboundOrderDate(@Param("firstDate") LocalDate firstDate, @Param("secondDate") LocalDate secondDate);
}