package com.unknown.deliveryserver.domain.order.order.dao;

import com.unknown.deliveryserver.domain.order.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByRestaurantId(Long restaurantId);
}
