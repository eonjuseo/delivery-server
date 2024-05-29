package com.unknown.deliveryserver.domain.order.enumerated;

import com.unknown.deliveryserver.global.exception.BusinessException;
import com.unknown.deliveryserver.global.response.HttpResponse;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrderStatus {
    WAITING_ACCEPT("주문 접수 대기", "1"),
    ACCEPTED("주문 접수", "2"),
    ON_DELIVERY("배송 중", "3"),
    DELIVERY_COMPLETED("배달 완료", "4"),
    ORDER_COMPLETED("주문 완료", "5"),
    ORDER_CANCELED("주문 취소", "6");

    private final String status;
    private final String statusNumber;

    OrderStatus(String status, String statusNumber) {
        this.status = status;
        this.statusNumber = statusNumber;
    }

    public static OrderStatus byStatus(String status) {
        return Arrays.stream(OrderStatus.values())
                .filter(value -> value.getStatus().equals(status))
                .findFirst()
                .orElseThrow(() -> BusinessException.builder()
                        .response(HttpResponse.Fail.NOT_FOUND_ORDER_STATUS)
                        .build());
    }

    public static OrderStatus byStatusNumber(String statusNumber) {
        return Arrays.stream(OrderStatus.values())
                .filter(value -> value.getStatusNumber().equals(statusNumber))
                .findFirst()
                .orElseThrow(() -> BusinessException.builder()
                        .response(HttpResponse.Fail.NOT_FOUND_ORDER_STATUS)
                        .build());
    }
}
