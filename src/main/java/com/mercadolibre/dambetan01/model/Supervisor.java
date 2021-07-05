package com.mercadolibre.dambetan01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="supervisors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supervisorId;
    private String supervisorName;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "supervisor_id", referencedColumnName = "warehouse_id")
    private Warehouse warehouse;

}
