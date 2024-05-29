package com.unknown.deliveryserver.domain.order.enumerated;

import lombok.Getter;

@Getter
public enum OrderStatus {
    // 주문 접수 대기
    WAITING_ACCEPT,

    // 주문 접수
    ACCEPTED,

    // 배달 중
    ON_DELIVERY,

    // 배달 완료
    DELIVERY_COMPLETED,

    // 주문 완료
    ORDER_COMPLETED,

    // 주문 취소
    ORDER_CANCELED
}
