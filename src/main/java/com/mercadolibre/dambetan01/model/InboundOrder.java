package com.mercadolibre.dambetan01.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Entity
@Table(name="inbound_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inboundOrderId;
    private LocalDate orderDate;

    @OneToMany(mappedBy = "inboundOrder")
    private List<InboundOrderHasBatch> inboundOrderHasBatches;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "inbound_order_id", referencedColumnName = "seller_id")
    private Seller seller;

}
