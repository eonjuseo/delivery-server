package com.unknown.deliveryserver.domain.restaurant.application;

import com.unknown.deliveryserver.domain.restaurant.dto.RestaurantResponse;
import com.unknown.deliveryserver.domain.restaurant.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<RestaurantResponse> getRestaurants();
    Restaurant getRestaurant(Long restaurantId);
}
