package com.unknown.deliveryserver.domain.restaurant.api;

import com.unknown.deliveryserver.domain.restaurant.application.RestaurantServiceImpl;
import com.unknown.deliveryserver.domain.restaurant.dto.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/restaurant")
@RestController
public class RestaurantController {

    private final RestaurantServiceImpl restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> getRestaurants() {
        List<RestaurantResponse> restaurantResponse = restaurantService.getRestaurants();
        return ResponseEntity.ok().body(restaurantResponse);
    }

}
