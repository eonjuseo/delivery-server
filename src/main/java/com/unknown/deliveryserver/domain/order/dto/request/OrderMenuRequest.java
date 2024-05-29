package com.unknown.deliveryserver.domain.order.dto.request;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class OrderMenuRequest {
    private Long menuId;
    private Long quantity;
    private List<Long> optionDetailIdList;
}
