package com.unknown.deliveryserver.domain.order.order.application;

import com.unknown.deliveryserver.domain.order.order.dto.request.OrderRequest;
import com.unknown.deliveryserver.domain.order.order.dto.response.OrderResponse;
import com.unknown.deliveryserver.domain.order.ordermenu.dto.response.OrderMenuResponse;
import com.unknown.deliveryserver.domain.order.ordermenu.entity.OrderMenu;
import com.unknown.deliveryserver.global.common.response.PageResponse;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse getOrder(Long orderId);
    PageResponse<OrderResponse> getOrdersByRestaurantId(Long restaurantId, Long cursorId, int size);
    BigDecimal getTotalPrice(List<OrderMenu> orderMenuList);
    List<OrderMenuResponse> createOrderMenuResponses(List<OrderMenu> orderMenuList);

}
