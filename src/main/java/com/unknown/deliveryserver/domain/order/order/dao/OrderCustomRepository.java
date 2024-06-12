package com.unknown.deliveryserver.domain.order.order.dao;

import com.unknown.deliveryserver.domain.order.order.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.time.LocalDate;

public interface OrderCustomRepository {
    Slice<Order> findByRestaurantId(Pageable pageable, Long restaurantId, Long cursorId, LocalDate start, LocalDate end);

}
