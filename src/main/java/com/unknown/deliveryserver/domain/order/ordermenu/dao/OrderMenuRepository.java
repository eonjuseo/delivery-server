package com.unknown.deliveryserver.domain.order.ordermenu.dao;

import com.unknown.deliveryserver.domain.order.ordermenu.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long> {
    List<OrderMenu> findByOrderId(Long orderId);
}
