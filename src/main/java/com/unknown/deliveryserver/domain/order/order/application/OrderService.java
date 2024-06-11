package com.unknown.deliveryserver.domain.order.order.application;

import com.unknown.deliveryserver.domain.order.order.dto.request.OrderRequest;
import com.unknown.deliveryserver.domain.order.order.dto.response.OrderResponse;
import com.unknown.deliveryserver.domain.order.ordermenu.dto.response.OrderMenuResponse;
import com.unknown.deliveryserver.domain.order.ordermenu.entity.OrderMenu;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse getOrder(Long orderId);
    Page<OrderResponse> getOrdersByRestaurantId(Long restaurantId, int page, int size);
    BigDecimal getTotalPrice(List<OrderMenu> orderMenuList);
    List<OrderMenuResponse> createOrderMenuResponses(List<OrderMenu> orderMenuList);

}
