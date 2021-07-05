package com.mercadolibre.dambetan01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class BatchHasPurchaseOrderPk implements Serializable {

    private Long batch;
    private Long purchaseOrder;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatchHasPurchaseOrderPk that = (BatchHasPurchaseOrderPk) o;
        return getBatch().equals(that.getBatch()) && getPurchaseOrder().equals(that.getPurchaseOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBatch(), getPurchaseOrder());
    }
}
