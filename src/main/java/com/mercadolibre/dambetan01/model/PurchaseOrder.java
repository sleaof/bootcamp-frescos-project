package com.mercadolibre.dambetan01.model;

import com.mercadolibre.dambetan01.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="purchase_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseOrderId;
    private Date date;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "purchaseOrder")
    private List<BatchHasPurchaseOrder> batchHasPurchaseOrders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id_fk", nullable = false)
    private Buyer buyer;

}
