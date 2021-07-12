package com.mercadolibre.dambetan01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;
    private Double minTemperature;
    private Double currentTemperature;
    private LocalDate manufacturingDate;
    private LocalDate manufacturingTime;
    private Long initialQuantity;
    private Long currentQuantity;
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id_fk")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id_fk")
    private Section section;

    @OneToMany(mappedBy = "batchs")
    private List<InboundOrderHasBatch> inboundOrderHasBatch;

    @OneToMany(mappedBy = "batch")
    private List<BatchHasPurchaseOrder> purchaseOrders;
}
