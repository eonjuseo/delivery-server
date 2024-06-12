package com.unknown.deliveryserver.domain.order.order.dao;

import com.unknown.deliveryserver.domain.order.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, OrderCustomRepository {
}
