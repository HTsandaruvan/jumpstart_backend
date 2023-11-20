package com.lithan.jumpstart.repository;

import com.lithan.jumpstart.constraint.EItemStatus;
import com.lithan.jumpstart.entity.Cart;
import com.lithan.jumpstart.entity.Item;
import com.lithan.jumpstart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByProduct(Product product);
    Item findByProductAndStatus(Product product, EItemStatus status);
    List<Item> findByCartAndProductIsNotNullAndStatus(Cart cart, EItemStatus status);
    List<Item> findAllByProductAndStatus(Product product, EItemStatus status);
    List<Item> findAllByCartAndStatus(Cart cart, EItemStatus status);
}
