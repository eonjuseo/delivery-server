package com.unknown.deliveryserver.domain.order.order.dao;

import com.unknown.deliveryserver.domain.order.order.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface OrderCustomRepository {
    Slice<Order> findByRestaurantId(Pageable pageable, Long restaurantId, Long cursorId);

}
