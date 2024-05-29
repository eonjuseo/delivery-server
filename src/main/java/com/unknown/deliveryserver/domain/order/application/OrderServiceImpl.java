package com.unknown.deliveryserver.domain.order.application;

import com.unknown.deliveryserver.domain.menu.menu.dao.MenuRepository;
import com.unknown.deliveryserver.domain.menu.menu.entity.Menu;
import com.unknown.deliveryserver.domain.menu.optiondetail.dao.OptionDetailRepository;
import com.unknown.deliveryserver.domain.menu.optiondetail.entity.OptionDetail;
import com.unknown.deliveryserver.domain.order.dao.OrderMenuRepository;
import com.unknown.deliveryserver.domain.order.dao.OrderOptionRepository;
import com.unknown.deliveryserver.domain.order.dao.OrderRepository;
import com.unknown.deliveryserver.domain.order.dto.request.OrderMenuRequest;
import com.unknown.deliveryserver.domain.order.dto.request.OrderRequest;
import com.unknown.deliveryserver.domain.order.dto.response.OrderMenuResponse;
import com.unknown.deliveryserver.domain.order.dto.response.OrderOptionResponse;
import com.unknown.deliveryserver.domain.order.dto.response.OrderResponse;
import com.unknown.deliveryserver.domain.order.entity.Order;
import com.unknown.deliveryserver.domain.order.entity.OrderMenu;
import com.unknown.deliveryserver.domain.order.entity.OrderOption;
import com.unknown.deliveryserver.domain.order.enumerated.OrderStatus;
import com.unknown.deliveryserver.domain.restaurant.dao.RestaurantRepository;
import com.unknown.deliveryserver.domain.restaurant.entity.Restaurant;
import com.unknown.deliveryserver.global.exception.BusinessException;
import com.unknown.deliveryserver.global.response.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final OrderOptionRepository orderOptionRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final OptionDetailRepository optionDetailRepository;

    @Transactional
    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Restaurant restaurant = restaurantRepository.findById(orderRequest.getRestaurantId())
                .orElseThrow(() -> new BusinessException(HttpResponse.Fail.NOT_FOUND_RESTAURANT));

        Order order = Order.builder()
                .restaurant(restaurant)
                .contact(orderRequest.getContact())
                .address(orderRequest.getAddress())
                .totalPrice(BigDecimal.ZERO)
                .build();
        orderRepository.save(order);

        List<OrderMenu> orderMenuList = new ArrayList<>();
        for(OrderMenuRequest orderMenuRequest : orderRequest.getOrderMenuList()) {
            Menu menu = menuRepository.findById(orderMenuRequest.getMenuId())
                    .orElseThrow(() -> BusinessException.builder()
                            .response(HttpResponse.Fail.NOT_FOUND_MENU).build());

            OrderMenu orderMenu = OrderMenu.builder()
                    .order(order)
                    .menu(menu)
                    .quantity(orderMenuRequest.getQuantity())
                    .build();
            orderMenuRepository.save(orderMenu);
            orderMenuList.add(orderMenu);

            for(Long optionDetailId : orderMenuRequest.getOptionDetailIdList()) {
                OptionDetail optionDetail = optionDetailRepository.findById(optionDetailId)
                        .orElseThrow(() -> BusinessException.builder()
                                .response(HttpResponse.Fail.NOT_FOUND_OPTION_DETAIL).build());

                OrderOption orderOption = OrderOption.builder()
                        .orderMenu(orderMenu)
                        .optionDetail(optionDetail)
                        .build();
                orderOptionRepository.save(orderOption);
            }
        }

        BigDecimal totalPrice = getTotalPrice(orderMenuList);

        order.setTotalPrice(totalPrice);
        order.setStatus(OrderStatus.WAITING_ACCEPT);
        orderRepository.save(order);

        List<OrderMenuResponse> orderMenuResponses = createOrderMenuResponses(orderMenuList);

        return OrderResponse.of(order, orderMenuResponses, totalPrice);
    }

    @Override
    public OrderResponse getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(HttpResponse.Fail.NOT_FOUND_ORDER));

        List<OrderMenu> orderMenuList = orderMenuRepository.findByOrderId(order.getId());
        List<OrderMenuResponse> orderMenuResponses = createOrderMenuResponses(orderMenuList);
        BigDecimal totalPrice = getTotalPrice(orderMenuList);

        return OrderResponse.of(order, orderMenuResponses, totalPrice);
    }

    @Override
    public List<OrderResponse> getOrdersByRestaurantId(Long restaurantId) {
        List<Order> orders = orderRepository.findByRestaurantId(restaurantId);

        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            List<OrderMenu> orderMenuList = orderMenuRepository.findByOrderId(order.getId());
            List<OrderMenuResponse> orderMenuResponses = createOrderMenuResponses(orderMenuList);

            BigDecimal totalPrice = getTotalPrice(orderMenuList);
            orderResponses.add(OrderResponse.of(order, orderMenuResponses, totalPrice));
        }

        return orderResponses;
    }

    @Override
    public BigDecimal getTotalPrice(List<OrderMenu> orderMenuList) {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for(OrderMenu orderMenu : orderMenuList) {
            BigDecimal menuPrice = orderMenu.getMenu().getMenuPrice();
            BigDecimal optionTotalPrice = BigDecimal.ZERO;

            List<OrderOption> orderOptionList = orderOptionRepository.findByOrderMenuId(orderMenu.getId());
            for(OrderOption orderOption : orderOptionList) {
                optionTotalPrice = optionTotalPrice.add(orderOption.getOptionDetail().getOptionPrice());
            }

            BigDecimal menuTotalPrice = (menuPrice.add(optionTotalPrice).multiply(BigDecimal.valueOf(orderMenu.getQuantity())));
            totalPrice = totalPrice.add(menuTotalPrice);
        }

        return totalPrice;
    }

    @Override
    public List<OrderMenuResponse> createOrderMenuResponses(List<OrderMenu> orderMenuList) {
        List<OrderMenuResponse> orderMenuResponses = new ArrayList<>();

        for (OrderMenu orderMenu : orderMenuList) {
            List<OrderOption> orderOptions = orderOptionRepository.findByOrderMenuId(orderMenu.getId());
            List<OrderOptionResponse> orderOptionResponses = new ArrayList<>();
            for (OrderOption orderOption : orderOptions) {
                orderOptionResponses.add(OrderOptionResponse.of(orderOption));
            }

            OrderMenuResponse orderMenuResponse = OrderMenuResponse.of(orderMenu, orderOptionResponses);
            orderMenuResponses.add(orderMenuResponse);
        }

        return orderMenuResponses;
    }
}
