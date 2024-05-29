package com.unknown.deliveryserver.domain.restaurant.application;

import com.unknown.deliveryserver.domain.restaurant.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    List<RestaurantResponse> getRestaurants();
}
