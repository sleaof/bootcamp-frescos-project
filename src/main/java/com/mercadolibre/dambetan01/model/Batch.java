package com.mercadolibre.dambetan01.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="batch")
@Getter
@Setter
@AllArgsConstructor
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
    @JoinColumn(name = "product_id_fk", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id_fk", nullable = false)
    private Section section;

    @OneToMany(mappedBy = "batch")
    private List<BatchHasPurchaseOrder> purchaseOrders;
}
