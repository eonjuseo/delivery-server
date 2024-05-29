package com.unknown.deliveryserver.domain.menu.util;

import com.unknown.deliveryserver.domain.menu.enumerated.StockStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StockStatusConverter implements AttributeConverter<StockStatus, String> {
    @Override
    public String convertToDatabaseColumn(StockStatus attribute) {
        return attribute.getStatusNumber();
    }

    @Override
    public StockStatus convertToEntityAttribute(String dbData) {
        return StockStatus.byStatusNumber(dbData);
    }

}
