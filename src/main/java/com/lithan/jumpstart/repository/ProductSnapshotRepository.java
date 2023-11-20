package com.lithan.jumpstart.repository;

import com.lithan.jumpstart.entity.Order;
import com.lithan.jumpstart.entity.Product;
import com.lithan.jumpstart.entity.ProductSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSnapshotRepository extends JpaRepository<ProductSnapshot, Long> {
    List<ProductSnapshot> findAllByOrder(Order order);
    List<ProductSnapshot> findAllByProduct(Product product);
    ProductSnapshot findBySlug(String slug);
}
