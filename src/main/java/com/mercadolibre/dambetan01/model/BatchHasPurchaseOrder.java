package com.mercadolibre.dambetan01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="batch_has_purchase_orders")
@Getter
@Setter
@AllArgsConstructor
@IdClass(BatchHasPurchaseOrderPk.class)
public class BatchHasPurchaseOrder {

    @Id
    @ManyToOne
    @JoinColumn(name = "batch_id", referencedColumnName = "batchId")
    private Batch batch;

    @Id
    @ManyToOne
    @JoinColumn(name = "purchaseOrder_id", referencedColumnName = "purchaseOrderId")
    private PurchaseOrder purchaseOrder;

    private Integer quantity;

}
