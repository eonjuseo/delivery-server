package com.unknown.deliveryserver.domain.order.dto.response;

import com.unknown.deliveryserver.domain.order.entity.OrderOption;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderOptionResponse {
    private Long optionDetailId;
    private String optionDetailName;
    private BigDecimal optionPrice;

    public static OrderOptionResponse of(OrderOption orderOption) {
        return OrderOptionResponse.builder()
                .optionDetailId(orderOption.getOptionDetail().getId())
                .optionDetailName(orderOption.getOptionDetail().getName())
                .optionPrice(orderOption.getOptionDetail().getOptionPrice())
                .build();
    }
}
