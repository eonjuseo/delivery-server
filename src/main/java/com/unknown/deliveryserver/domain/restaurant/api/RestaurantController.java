package com.unknown.deliveryserver.domain.restaurant.api;

import com.unknown.deliveryserver.domain.order.order.application.OrderServiceImpl;
import com.unknown.deliveryserver.domain.order.order.dto.response.OrderResponse;
import com.unknown.deliveryserver.domain.restaurant.application.RestaurantServiceImpl;
import com.unknown.deliveryserver.domain.restaurant.dto.RestaurantResponse;
import com.unknown.deliveryserver.domain.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/restaurants")
@RestController
public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;
    private final OrderServiceImpl orderService;

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> getRestaurants() {
        List<RestaurantResponse> restaurantResponse = restaurantService.getRestaurants();
        return ResponseEntity.ok().body(restaurantResponse);
    }

    @GetMapping("{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        return ResponseEntity.ok().body(restaurant);
    }

    @GetMapping("{id}/orders")
    public ResponseEntity<List<OrderResponse>> getOrdersByRestaurant(@PathVariable("id") Long restaurantId) {
        List<OrderResponse> orderResponse = orderService.getOrdersByRestaurantId(restaurantId);

        return ResponseEntity.ok().body(orderResponse);
    }
}
