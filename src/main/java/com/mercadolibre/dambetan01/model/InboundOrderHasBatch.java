package com.mercadolibre.dambetan01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "inbound_order_has_batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderHasBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inboundOrderHasBatchId;
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inbound_order_id_fk", nullable = false)
    private InboundOrder inboundOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id_fk", nullable = false)
    private Batch batchs;
}
