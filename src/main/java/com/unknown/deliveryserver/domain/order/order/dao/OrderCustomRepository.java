package com.unknown.deliveryserver.domain.order.order.dao;

import com.unknown.deliveryserver.domain.order.order.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderCustomRepository {
    Page<Order> findByRestaurantId(Pageable pageable, Long restaurantId);

}
