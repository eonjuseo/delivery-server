package com.unknown.deliveryserver.domain.order.dto.request;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class OrderRequest {
    private Long restaurantId;
    private Long contact;
    private String address;
    private List<OrderMenuRequest> orderMenuList;
}
