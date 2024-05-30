package com.unknown.deliveryserver.domain.order.order.application;

import com.unknown.deliveryserver.domain.order.order.dto.request.OrderRequest;
import com.unknown.deliveryserver.domain.order.ordermenu.dto.response.OrderMenuResponse;
import com.unknown.deliveryserver.domain.order.order.dto.response.OrderResponse;
import com.unknown.deliveryserver.domain.order.ordermenu.entity.OrderMenu;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse getOrder(Long orderId);
    List<OrderResponse> getOrdersByRestaurantId(Long restaurantId);
    BigDecimal getTotalPrice(List<OrderMenu> orderMenuList);
    List<OrderMenuResponse> createOrderMenuResponses(List<OrderMenu> orderMenuList);

}
