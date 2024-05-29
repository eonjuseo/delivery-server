package com.unknown.deliveryserver.domain.order.dto.response;

import com.unknown.deliveryserver.domain.order.entity.Order;
import com.unknown.deliveryserver.domain.order.enumerated.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponse {
    private Long id;
    private Long restaurantId;
    private Long contact;
    private String address;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private List<OrderMenuResponse> orderMenuList;

    public static OrderResponse of(Order order, List<OrderMenuResponse> orderMenuList, BigDecimal totalPrice) {
        return OrderResponse.builder()
                .id(order.getId())
                .restaurantId(order.getRestaurant().getId())
                .contact(order.getContact())
                .address(order.getAddress())
                .totalPrice(totalPrice)
                .status(order.getStatus())
                .orderMenuList(orderMenuList)
                .build();
    }
}
