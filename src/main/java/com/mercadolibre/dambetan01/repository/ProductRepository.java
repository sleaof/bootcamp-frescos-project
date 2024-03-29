package com.mercadolibre.dambetan01.repository;

import com.mercadolibre.dambetan01.model.Product;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from products as p where p.product_category = :category", nativeQuery = true)
    List<Product> findByCategory(@Param("category") String category);

    @Query(value= "select * from view_most_selling_products", nativeQuery = true)
    List<JSONObject> findTheThreeBestSellingProducts();
}
