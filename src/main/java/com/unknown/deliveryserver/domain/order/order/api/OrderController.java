package com.unknown.deliveryserver.domain.order.order.api;

import com.unknown.deliveryserver.domain.order.order.application.OrderServiceImpl;
import com.unknown.deliveryserver.domain.order.order.dto.request.OrderRequest;
import com.unknown.deliveryserver.domain.order.order.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/order")
@RestController
public class OrderController {
    private final OrderServiceImpl orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.createOrder(orderRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(orderResponse.getId())
                .toUri();

        return ResponseEntity.created(location).body(orderResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") Long orderId) {
        OrderResponse orderResponse = orderService.getOrder(orderId);

        return ResponseEntity.ok().body(orderResponse);
    }

    @GetMapping("restaurant/{id}")
    public ResponseEntity<List<OrderResponse>> getOrdersByRestaurant(@PathVariable("id") Long restaurantId) {
        List<OrderResponse> orderResponse = orderService.getOrdersByRestaurantId(restaurantId);

        return ResponseEntity.ok().body(orderResponse);
    }
}
