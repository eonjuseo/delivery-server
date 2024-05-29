package com.unknown.deliveryserver.domain.menu.enumerated;

import lombok.Getter;

@Getter
public enum StockStatus {
    // Menu, OptionDetail 에 대한

    // 주문 가능
    ENABLE,

    // 품절
    DISABLE;
}
