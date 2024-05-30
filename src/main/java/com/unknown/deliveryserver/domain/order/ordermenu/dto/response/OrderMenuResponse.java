package com.unknown.deliveryserver.domain.order.ordermenu.dto.response;

import com.unknown.deliveryserver.domain.order.orderoption.dto.OrderOptionResponse;
import com.unknown.deliveryserver.domain.order.ordermenu.entity.OrderMenu;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderMenuResponse {
    private String menuName;
    private Long quantity;
    private BigDecimal menuPrice;
    private List<OrderOptionResponse> orderOptionList;

    public static OrderMenuResponse of(OrderMenu orderMenu, List<OrderOptionResponse> orderOptionList) {
        return OrderMenuResponse.builder()
                .menuName(orderMenu.getMenu().getName())
                .quantity(orderMenu.getQuantity())
                .menuPrice(orderMenu.getMenu().getMenuPrice())
                .orderOptionList(orderOptionList)
                .build();
    }
}
