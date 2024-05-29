package com.unknown.deliveryserver.domain.order.util;

import com.unknown.deliveryserver.domain.order.enumerated.OrderStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {
    @Override
    public String convertToDatabaseColumn(OrderStatus attribute) {
        return attribute.getStatusNumber();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String dbData) {
        return OrderStatus.byStatusNumber(dbData);
    }

}
