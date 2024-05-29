package com.unknown.deliveryserver.domain.restaurant.application;

import com.unknown.deliveryserver.domain.restaurant.dao.RestaurantRepository;
import com.unknown.deliveryserver.domain.restaurant.dto.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantResponse> getRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(RestaurantResponse::of)
                .collect(Collectors.toList());
    }
}
