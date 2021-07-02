package com.mercadolibre.dambetan01.model;

import com.mercadolibre.dambetan01.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String addressName;
    private String street;
    private String city;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "warehouse_id")
    private Warehouse warehouse;

}
