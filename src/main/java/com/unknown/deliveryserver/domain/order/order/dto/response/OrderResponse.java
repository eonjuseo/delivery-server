package com.unknown.deliveryserver.domain.order.order.dto.response;

import com.unknown.deliveryserver.domain.order.order.entity.Order;
import com.unknown.deliveryserver.domain.order.enumerated.OrderStatus;
import com.unknown.deliveryserver.domain.order.ordermenu.dto.response.OrderMenuResponse;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponse {
    private Long id;
    private String restaurantName;
    private Long contact;
    private String address;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private List<OrderMenuResponse> orderMenuList;

    public static OrderResponse of(Order order, List<OrderMenuResponse> orderMenuList, BigDecimal totalPrice) {
        return OrderResponse.builder()
                .id(order.getId())
                .restaurantName(order.getRestaurant().getName())
                .contact(order.getContact())
                .address(order.getAddress())
                .totalPrice(totalPrice)
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .orderMenuList(orderMenuList)
                .build();
    }
}
