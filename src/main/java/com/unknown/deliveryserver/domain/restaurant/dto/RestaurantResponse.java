package com.unknown.deliveryserver.domain.restaurant.dto;

import com.unknown.deliveryserver.domain.restaurant.entity.Restaurant;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantResponse {
    private Long id;
    private String name;

    public static RestaurantResponse of(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .build();
    }
}
