package com.mercadolibre.dambetan01.model;


import com.mercadolibre.dambetan01.enums.SectionCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sections")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;
    @Enumerated(EnumType.STRING)
    private SectionCategory sectionNameCategory;
    private Double minTemperature;
    private Double maxTemperature;
    private Double currentTemperature;

    @OneToMany(mappedBy = "section")
    private List<Batch> batchs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id_fk")
    private Warehouse warehouse;
}
