package com.mercadolibre.dambetan01.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="inbound_order_has_batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InboundOrderHasBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inboundOrderHasBatchId;
    private Long quantity;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inbound_order_id_fk", nullable = false)
    private InboundOrder inboundOrder;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id_fk", nullable = false)
    private Batch batchs;

}
