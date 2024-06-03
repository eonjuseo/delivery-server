package com.unknown.deliveryserver.global.init;

import com.unknown.deliveryserver.domain.menu.enumerated.StockStatus;
import com.unknown.deliveryserver.domain.menu.menu.dao.MenuRepository;
import com.unknown.deliveryserver.domain.menu.menu.entity.Menu;
import com.unknown.deliveryserver.domain.menu.option.dao.OptionRepository;
import com.unknown.deliveryserver.domain.menu.option.entity.Option;
import com.unknown.deliveryserver.domain.menu.optiondetail.dao.OptionDetailRepository;
import com.unknown.deliveryserver.domain.menu.optiondetail.entity.OptionDetail;
import com.unknown.deliveryserver.domain.order.enumerated.OrderStatus;
import com.unknown.deliveryserver.domain.order.order.dao.OrderRepository;
import com.unknown.deliveryserver.domain.order.order.entity.Order;
import com.unknown.deliveryserver.domain.order.ordermenu.dao.OrderMenuRepository;
import com.unknown.deliveryserver.domain.order.ordermenu.entity.OrderMenu;
import com.unknown.deliveryserver.domain.order.orderoption.dao.OrderOptionRepository;
import com.unknown.deliveryserver.domain.order.orderoption.entity.OrderOption;
import com.unknown.deliveryserver.domain.restaurant.dao.RestaurantRepository;
import com.unknown.deliveryserver.domain.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Profile("!prod")
@RequiredArgsConstructor
@Configuration
public class NotProd {
    @Autowired
    @Lazy
    private NotProd self;

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final OrderOptionRepository orderOptionRepository;
    private final OptionDetailRepository optionDetailRepository;
    private final OptionRepository optionRepository;

    @Bean
    public ApplicationRunner initNotProd() {
        return args -> {
            self.work1();
        };
    }
    @Transactional
    public void work1() throws IOException {
        if (restaurantRepository.existsById(1L)) {
            return;
        }
        // Restaurant
        Restaurant restaurant1 = Restaurant.builder().name("치킨집").contact(428681004L).build();
        restaurantRepository.save(restaurant1);
        Restaurant restaurant2 = Restaurant.builder().name("피자집").contact(428681005L).build();
        restaurantRepository.save(restaurant2);
        Restaurant restaurant3 = Restaurant.builder().name("버거집").contact(428681006L).build();
        restaurantRepository.save(restaurant3);

        // Menu
        Menu res_1_menu_1 = Menu.builder().name("황금올리브").restaurant(restaurant1).menuPrice(BigDecimal.valueOf(20000)).status(StockStatus.ENABLE).build();
        menuRepository.save(res_1_menu_1);
        Menu res_1_menu_2 = Menu.builder().name("소떡만나").restaurant(restaurant1).menuPrice(BigDecimal.valueOf(24000)).status(StockStatus.ENABLE).build();
        menuRepository.save(res_1_menu_2);

        Menu res_2_menu_1 = Menu.builder().name("포테이토 피자").restaurant(restaurant2).menuPrice(BigDecimal.valueOf(26000)).status(StockStatus.ENABLE).build();
        menuRepository.save(res_2_menu_1);
        Menu res_2_menu_2 = Menu.builder().name("페퍼로니 피자").restaurant(restaurant2).menuPrice(BigDecimal.valueOf(25000)).status(StockStatus.ENABLE).build();
        menuRepository.save(res_2_menu_2);

        Menu res_3_menu_1 = Menu.builder().name("치즈버거").restaurant(restaurant3).menuPrice(BigDecimal.valueOf(9000)).status(StockStatus.ENABLE).build();
        menuRepository.save(res_3_menu_1);
        Menu res_3_menu_2 = Menu.builder().name("치킨버거").restaurant(restaurant3).menuPrice(BigDecimal.valueOf(8500)).status(StockStatus.ENABLE).build();
        menuRepository.save(res_3_menu_2);

        // Option
        // 치킨집
        // 치킨1
        Option res_1_menu_1_option_1 = Option.builder().name("부위 선택").menu(res_1_menu_1).isNecessary(true).build();
        optionRepository.save(res_1_menu_1_option_1);
        Option res_1_menu_1_option_2 = Option.builder().name("사이드 선택").menu(res_1_menu_1).isNecessary(false).build();
        optionRepository.save(res_1_menu_1_option_2);
        // 치킨2
        Option res_1_menu_2_option_1 = Option.builder().name("부위 선택").menu(res_1_menu_2).isNecessary(true).build();
        optionRepository.save(res_1_menu_2_option_1);
        Option res_1_menu_2_option_2 = Option.builder().name("사이드 선택").menu(res_1_menu_2).isNecessary(false).build();
        optionRepository.save(res_1_menu_2_option_2);

        // 피자집
        // 피자1
        Option res_2_menu_1_option_1 = Option.builder().name("사이즈 선택").menu(res_2_menu_1).isNecessary(true).build();
        optionRepository.save(res_2_menu_1_option_1);
        Option res_2_menu_1_option_2 = Option.builder().name("사이드 선택").menu(res_2_menu_1).isNecessary(false).build();
        optionRepository.save(res_2_menu_1_option_2);
        // 피자2
        Option res_2_menu_2_option_1 = Option.builder().name("사이즈 선택").menu(res_2_menu_1).isNecessary(true).build();
        optionRepository.save(res_2_menu_2_option_1);
        Option res_2_menu_2_option_2 = Option.builder().name("사이드 선택").menu(res_2_menu_1).isNecessary(false).build();
        optionRepository.save(res_2_menu_2_option_2);

        // 버거집
        // 버거1
        Option res_3_menu_1_option_1 = Option.builder().name("추가 토핑 선택").menu(res_3_menu_1).isNecessary(false).build();
        optionRepository.save(res_3_menu_1_option_1);
        Option res_3_menu_1_option_2 = Option.builder().name("사이드 선택").menu(res_3_menu_1).isNecessary(false).build();
        optionRepository.save(res_3_menu_1_option_2);
        // 버거2
        Option res_3_menu_2_option_1 = Option.builder().name("추가 토핑 선택").menu(res_3_menu_2).isNecessary(false).build();
        optionRepository.save(res_3_menu_2_option_1);
        Option res_3_menu_2_option_2 = Option.builder().name("사이드 선택").menu(res_3_menu_1).isNecessary(false).build();
        optionRepository.save(res_3_menu_2_option_2);

        // OptionDetail
        // 치킨1
        OptionDetail res_1_menu_1_option_1_1 = OptionDetail.builder().name("순살").option(res_1_menu_1_option_1).optionPrice(BigDecimal.valueOf(2000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_1_menu_1_option_1_1);
        OptionDetail res_1_menu_1_option_1_2 = OptionDetail.builder().name("뼈").option(res_1_menu_1_option_1).optionPrice(BigDecimal.valueOf(0)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_1_menu_1_option_1_2);

        OptionDetail res_1_menu_1_option_2_1 = OptionDetail.builder().name("황금알치즈볼").option(res_1_menu_1_option_2).optionPrice(BigDecimal.valueOf(5000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_1_menu_1_option_2_1);
        OptionDetail res_1_menu_1_option_2_2 = OptionDetail.builder().name("크림치즈볼").option(res_1_menu_1_option_2).optionPrice(BigDecimal.valueOf(5000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_1_menu_1_option_2_2);

        // 치킨2
        OptionDetail res_1_menu_2_option_1_1 = OptionDetail.builder().name("순살").option(res_1_menu_2_option_1).optionPrice(BigDecimal.valueOf(2000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_1_menu_2_option_1_1);
        OptionDetail res_1_menu_2_option_1_2 = OptionDetail.builder().name("뼈").option(res_1_menu_2_option_1).optionPrice(BigDecimal.valueOf(0)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_1_menu_2_option_1_2);

        OptionDetail res_1_menu_2_option_2_1 = OptionDetail.builder().name("황금알치즈볼").option(res_1_menu_2_option_2).optionPrice(BigDecimal.valueOf(5000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_1_menu_2_option_2_1);
        OptionDetail res_1_menu_2_option_2_2 = OptionDetail.builder().name("크림치즈볼").option(res_1_menu_2_option_2).optionPrice(BigDecimal.valueOf(5000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_1_menu_2_option_2_2);

        // 피자1
        OptionDetail res_2_menu_1_option_1_1 = OptionDetail.builder().name("medium").option(res_2_menu_1_option_1).optionPrice(BigDecimal.valueOf(0)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_2_menu_1_option_1_1);
        OptionDetail res_2_menu_1_option_1_2 = OptionDetail.builder().name("large").option(res_2_menu_1_option_1).optionPrice(BigDecimal.valueOf(5000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_2_menu_1_option_1_2);

        OptionDetail res_2_menu_1_option_2_1 = OptionDetail.builder().name("오븐스파게티").option(res_2_menu_1_option_2).optionPrice(BigDecimal.valueOf(7000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_2_menu_1_option_2_1);
        OptionDetail res_2_menu_1_option_2_2 = OptionDetail.builder().name("핫윙").option(res_2_menu_1_option_2).optionPrice(BigDecimal.valueOf(4000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_2_menu_1_option_2_2);

        // 피자2
        OptionDetail res_2_menu_2_option_1_1 = OptionDetail.builder().name("medium").option(res_2_menu_2_option_1).optionPrice(BigDecimal.valueOf(0)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_2_menu_2_option_1_1);
        OptionDetail res_2_menu_2_option_1_2 = OptionDetail.builder().name("large").option(res_2_menu_2_option_1).optionPrice(BigDecimal.valueOf(5000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_2_menu_2_option_1_2);

        OptionDetail res_2_menu_2_option_2_1 = OptionDetail.builder().name("오븐스파게티").option(res_2_menu_2_option_2).optionPrice(BigDecimal.valueOf(7000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_2_menu_2_option_2_1);
        OptionDetail res_2_menu_2_option_2_2 = OptionDetail.builder().name("핫윙").option(res_2_menu_2_option_2).optionPrice(BigDecimal.valueOf(4000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_2_menu_2_option_2_2);

        // 버거1
        OptionDetail res_3_menu_1_option_1_1 = OptionDetail.builder().name("치즈 추가").option(res_3_menu_1_option_1).optionPrice(BigDecimal.valueOf(1000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_3_menu_1_option_1_1);
        OptionDetail res_3_menu_1_option_1_2 = OptionDetail.builder().name("베이컨 추가").option(res_3_menu_1_option_1).optionPrice(BigDecimal.valueOf(1500)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_3_menu_1_option_1_2);

        OptionDetail res_3_menu_1_option_2_1 = OptionDetail.builder().name("오리지널 프라이").option(res_3_menu_1_option_1).optionPrice(BigDecimal.valueOf(4000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_3_menu_1_option_2_1);
        OptionDetail res_3_menu_1_option_2_2 = OptionDetail.builder().name("갈릭버터 프라이").option(res_3_menu_1_option_1).optionPrice(BigDecimal.valueOf(5000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_3_menu_1_option_2_2);

        // 버거2
        OptionDetail res_3_menu_2_option_1_1 = OptionDetail.builder().name("치즈 추가").option(res_3_menu_2_option_1).optionPrice(BigDecimal.valueOf(1000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_3_menu_2_option_1_1);
        OptionDetail res_3_menu_2_option_1_2 = OptionDetail.builder().name("베이컨 추가").option(res_3_menu_2_option_1).optionPrice(BigDecimal.valueOf(1500)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_3_menu_2_option_1_2);

        OptionDetail res_3_menu_2_option_2_1 = OptionDetail.builder().name("오리지널 프라이").option(res_3_menu_2_option_1).optionPrice(BigDecimal.valueOf(4000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_3_menu_2_option_2_1);
        OptionDetail res_3_menu_2_option_2_2 = OptionDetail.builder().name("갈릭버터 프라이").option(res_3_menu_2_option_1).optionPrice(BigDecimal.valueOf(5000)).status(StockStatus.ENABLE).build();
        optionDetailRepository.save(res_3_menu_2_option_2_2);

//        // Order
//        Order order1 = Order.builder().restaurant(restaurant1).contact(1012341234L).address("엔터팰리스1차").status(OrderStatus.ACCEPTED).build();
//        orderRepository.save(order1); // 메뉴1+순살+치즈볼 메뉴2+뼈
//
//        OrderMenu orderMenu1_1 = OrderMenu.builder().order(order1).menu(res_1_menu_1).quantity(1L).build();
//        orderMenuRepository.save(orderMenu1_1); // 20000
//        OrderOption orderOption1_1 = OrderOption.builder().orderMenu(orderMenu1_1).optionDetail(res_1_menu_1_option_1_1).build();
//        orderOptionRepository.save(orderOption1_1); // 2000
//        OrderOption orderOption1_2 = OrderOption.builder().orderMenu(orderMenu1_1).optionDetail(res_1_menu_1_option_2_1).build();
//        orderOptionRepository.save(orderOption1_2); // 5000
//
//        OrderMenu orderMenu1_2 = OrderMenu.builder().order(order1).menu(res_1_menu_2).quantity(1L).build();
//        orderMenuRepository.save(orderMenu1_2); // 24000
//        OrderOption orderOption1_2_1 = OrderOption.builder().orderMenu(orderMenu1_2).optionDetail(res_1_menu_2_option_1_2).build();
//        orderOptionRepository.save(orderOption1_2_1); // 0
//
//
//        Order order2 = Order.builder().restaurant(restaurant2).contact(1056785678L).address("엔터팰리스2차").status(OrderStatus.ACCEPTED).build();
//        orderRepository.save(order2); // 메뉴1+라지+핫윙
//
//        OrderMenu orderMenu2_1 = OrderMenu.builder().order(order2).menu(res_2_menu_1).quantity(1L).build();
//        orderMenuRepository.save(orderMenu2_1); // 26000
//        OrderOption orderOption2_1_1 = OrderOption.builder().orderMenu(orderMenu2_1).optionDetail(res_2_menu_1_option_1_2).build();
//        orderOptionRepository.save(orderOption2_1_1); //5000
//        OrderOption orderOption2_1_2 = OrderOption.builder().orderMenu(orderMenu2_1).optionDetail(res_2_menu_1_option_2_2).build();
//        orderOptionRepository.save(orderOption2_1_2); //4000
//
//
//        Order order3 = Order.builder().restaurant(restaurant1).contact(1012345678L).address("엔터팰리스3차").status(OrderStatus.ACCEPTED).build();
//        orderRepository.save(order3); // 메뉴1+순살+치즈볼
//
//        orderMenu1_1 = OrderMenu.builder().order(order3).menu(res_1_menu_1).quantity(1L).build();
//        orderMenuRepository.save(orderMenu1_1); // 20000
//        orderOption1_1 = OrderOption.builder().orderMenu(orderMenu1_1).optionDetail(res_1_menu_1_option_1_1).build();
//        orderOptionRepository.save(orderOption1_1); // 2000
//        orderOption1_2 = OrderOption.builder().orderMenu(orderMenu1_1).optionDetail(res_1_menu_1_option_2_1).build();
//        orderOptionRepository.save(orderOption1_2); // 5000
//
//        Order order4 = Order.builder().restaurant(restaurant3).contact(1098765432L).address("엔터팰리스4차").status(OrderStatus.ACCEPTED).build();
//        orderRepository.save(order4); // 메뉴1+치즈 추가
//
//        OrderMenu orderMenu4_1 = OrderMenu.builder().order(order4).menu(res_3_menu_1).quantity(1L).build();
//        orderMenuRepository.save(orderMenu4_1); // 9000
//        OrderOption orderOption4_1_1 = OrderOption.builder().orderMenu(orderMenu4_1).optionDetail(res_3_menu_1_option_1_1).build();
//        orderOptionRepository.save(orderOption4_1_1); // 1000
//
//        Order order5 = Order.builder().restaurant(restaurant3).contact(1098547632L).address("엔터팰리스5차").status(OrderStatus.ACCEPTED).build();
//        orderRepository.save(order5); // 메뉴2+베이컨 추가
//
//        OrderMenu orderMenu5_1 = OrderMenu.builder().order(order5).menu(res_3_menu_2).quantity(1L).build();
//        orderMenuRepository.save(orderMenu5_1); // 8500
//        OrderOption orderOption5_1_1 = OrderOption.builder().orderMenu(orderMenu5_1).optionDetail(res_3_menu_2_option_1_2).build();
//        orderOptionRepository.save(orderOption5_1_1); // 1500

        for (int i = 0; i < 1000; i++) {
            createOrderForRestaurant(restaurant1, res_1_menu_1, res_1_menu_1_option_1_1, res_1_menu_1_option_2_1, i);
            createOrderForRestaurant(restaurant2, res_2_menu_1, res_2_menu_1_option_1_1, res_2_menu_1_option_2_1, i);
            createOrderForRestaurant(restaurant3, res_3_menu_1, res_3_menu_1_option_1_1, res_3_menu_1_option_2_1, i);
        }
    }
    private void createOrderForRestaurant(Restaurant restaurant, Menu menu, OptionDetail optionDetail1, OptionDetail optionDetail2, int daysBefore) {
        Order order = Order.builder()
                .restaurant(restaurant)
                .contact(1000000000L + daysBefore)
                .address("엔터팰리스" + (daysBefore + 1) + "차")
                .status(OrderStatus.ACCEPTED)
                .createdAt(LocalDateTime.now().minusDays(daysBefore))
                .build();
        orderRepository.save(order);

        OrderMenu orderMenu = OrderMenu.builder().order(order).menu(menu).quantity(1L).build();
        orderMenuRepository.save(orderMenu);

        OrderOption orderOption1 = OrderOption.builder().orderMenu(orderMenu).optionDetail(optionDetail1).build();
        orderOptionRepository.save(orderOption1);

        OrderOption orderOption2 = OrderOption.builder().orderMenu(orderMenu).optionDetail(optionDetail2).build();
        orderOptionRepository.save(orderOption2);
    }
}
