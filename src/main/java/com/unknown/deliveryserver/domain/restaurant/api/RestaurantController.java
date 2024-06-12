package com.unknown.deliveryserver.domain.restaurant.api;

import com.unknown.deliveryserver.domain.order.order.application.OrderService;
import com.unknown.deliveryserver.domain.order.order.dto.response.OrderResponse;
import com.unknown.deliveryserver.domain.restaurant.application.RestaurantService;
import com.unknown.deliveryserver.domain.restaurant.dto.RestaurantResponse;
import com.unknown.deliveryserver.domain.restaurant.entity.Restaurant;
import com.unknown.deliveryserver.global.common.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/restaurants")
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final OrderService orderService;

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
    public ResponseEntity<PageResponse<OrderResponse>> getOrdersByRestaurant(@PathVariable("id") Long restaurantId,
                                                                             @RequestParam(name = "cursorId", required = false) Long cursorId,
                                                                             @RequestParam(name = "size", defaultValue = "20") int size) {
        PageResponse<OrderResponse> orderResponse = orderService.getOrdersByRestaurantId(restaurantId, cursorId, size);

        return ResponseEntity.ok().body(orderResponse);
    }
}
