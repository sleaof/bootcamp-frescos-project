package com.mercadolibre.dambetan01.model;

import com.mercadolibre.dambetan01.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Double temperature;
    private LocalDate validated;
    private ProductCategory productCategory;


    @OneToMany(mappedBy = "product")
    private List<Batch> batchs;


}
