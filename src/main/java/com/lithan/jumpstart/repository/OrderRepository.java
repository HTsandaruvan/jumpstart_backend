package com.lithan.jumpstart.repository;

import com.lithan.jumpstart.constraint.EOrderStatus;
import com.lithan.jumpstart.entity.Order;
import com.lithan.jumpstart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUser(User user);
    List<Order> findAllByStatus(EOrderStatus status);
    List<Order> findAllByUserAndStatus(User user, EOrderStatus status);
}
