package com.unknown.deliveryserver.domain.order.orderoption.dao;

import com.unknown.deliveryserver.domain.order.orderoption.entity.OrderOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderOptionRepository extends JpaRepository<OrderOption, Long> {
    List<OrderOption> findByOrderMenuId(Long orderMenuId);
}
