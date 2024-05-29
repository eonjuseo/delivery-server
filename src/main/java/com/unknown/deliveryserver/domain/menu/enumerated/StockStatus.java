package com.unknown.deliveryserver.domain.menu.enumerated;

import com.unknown.deliveryserver.global.exception.BusinessException;
import com.unknown.deliveryserver.global.response.HttpResponse;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum StockStatus {
    ENABLE("주문 가능", "1"),
    DISABLE("품절", "2");

    private final String status;
    private final String statusNumber;

    StockStatus(String status, String statusNumber) {
        this.status = status;
        this.statusNumber = statusNumber;
    }

    public static StockStatus byStatus(String status) {
        return Arrays.stream(StockStatus.values())
                .filter(value -> value.getStatus().equals(status))
                .findFirst()
                .orElseThrow(() -> BusinessException.builder()
                        .response(HttpResponse.Fail.NOT_FOUND_STOCK_STATUS)
                        .build());
    }

    public static StockStatus byStatusNumber(String statusNumber) {
        return Arrays.stream(StockStatus.values())
                .filter(value -> value.getStatusNumber().equals(statusNumber))
                .findFirst()
                .orElseThrow(() -> BusinessException.builder()
                        .response(HttpResponse.Fail.NOT_FOUND_STOCK_STATUS)
                        .build());
    }
}
