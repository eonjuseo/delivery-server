package com.unknown.deliveryserver.domain.order.orderoption.dto;

import com.unknown.deliveryserver.domain.order.orderoption.entity.OrderOption;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderOptionResponse {
    private String optionDetailName;
    private BigDecimal optionPrice;

    public static OrderOptionResponse of(OrderOption orderOption) {
        return OrderOptionResponse.builder()
                .optionDetailName(orderOption.getOptionDetail().getName())
                .optionPrice(orderOption.getOptionDetail().getOptionPrice())
                .build();
    }
}
