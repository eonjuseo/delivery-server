package com.unknown.deliveryserver.domain.order.dao;

import com.unknown.deliveryserver.domain.order.entity.OrderOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderOptionRepository extends JpaRepository<OrderOption, Long> {
    List<OrderOption> findByOrderMenuId(Long orderMenuId);
}
