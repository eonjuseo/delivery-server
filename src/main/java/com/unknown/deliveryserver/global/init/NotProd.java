package com.unknown.deliveryserver.global.init;

import com.unknown.deliveryserver.domain.menu.enumerated.StockStatus;
import com.unknown.deliveryserver.domain.menu.menu.dao.MenuRepository;
import com.unknown.deliveryserver.domain.menu.menu.entity.Menu;
import com.unknown.deliveryserver.domain.menu.option.dao.OptionRepository;
import com.unknown.deliveryserver.domain.menu.option.entity.Option;
import com.unknown.deliveryserver.domain.menu.optiondetail.dao.OptionDetailRepository;
import com.unknown.deliveryserver.domain.menu.optiondetail.entity.OptionDetail;
import com.unknown.deliveryserver.domain.order.dao.OrderMenuRepository;
import com.unknown.deliveryserver.domain.order.dao.OrderOptionRepository;
import com.unknown.deliveryserver.domain.order.dao.OrderRepository;
import com.unknown.deliveryserver.domain.order.entity.Order;
import com.unknown.deliveryserver.domain.order.entity.OrderMenu;
import com.unknown.deliveryserver.domain.order.entity.OrderOption;
import com.unknown.deliveryserver.domain.order.enumerated.OrderStatus;
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

        // Order
        Order order1 = Order.builder()
                .restaurant(restaurant1)
                .contact(1012341234L)
                .address("엔터팰리스1차")
                .status(OrderStatus.ACCEPTED)
                .build();
        orderRepository.save(order1); // 메뉴1+순살+치즈볼 메뉴2+뼈

        OrderMenu orderMenu1_1 = OrderMenu.builder().order(order1).menu(res_1_menu_1).quantity(1L).build();
        orderMenuRepository.save(orderMenu1_1); // 20000
        OrderOption orderOption1_1 = OrderOption.builder().orderMenu(orderMenu1_1).optionDetail(res_1_menu_1_option_1_1).build();
        orderOptionRepository.save(orderOption1_1); // 2000
        OrderOption orderOption1_2 = OrderOption.builder().orderMenu(orderMenu1_1).optionDetail(res_1_menu_1_option_2_1).build();
        orderOptionRepository.save(orderOption1_2); // 5000

        OrderMenu orderMenu1_2 = OrderMenu.builder().order(order1).menu(res_1_menu_2).quantity(1L).build();
        orderMenuRepository.save(orderMenu1_2); // 24000
        OrderOption orderOption1_2_1 = OrderOption.builder().orderMenu(orderMenu1_2).optionDetail(res_1_menu_2_option_1_2).build();
        orderOptionRepository.save(orderOption1_2_1); // 0


        Order order2 = Order.builder()
                .restaurant(restaurant2)
                .contact(1056785678L)
                .address("엔터팰리스2차")
                .status(OrderStatus.ACCEPTED)
                .build();
        orderRepository.save(order2); // 메뉴1+라지+핫윙

        OrderMenu orderMenu2_1 = OrderMenu.builder().order(order2).menu(res_2_menu_1).quantity(1L).build();
        orderMenuRepository.save(orderMenu2_1); // 26000
        OrderOption orderOption2_1_1 = OrderOption.builder().orderMenu(orderMenu2_1).optionDetail(res_2_menu_1_option_1_2).build();
        orderOptionRepository.save(orderOption2_1_1); //5000
        OrderOption orderOption2_1_2 = OrderOption.builder().orderMenu(orderMenu2_1).optionDetail(res_2_menu_1_option_2_2).build();
        orderOptionRepository.save(orderOption2_1_2); //4000


        Order order3 = Order.builder()
                .restaurant(restaurant1)
                .contact(1012345678L)
                .address("엔터팰리스3차")
                .status(OrderStatus.ACCEPTED)
                .build();
        orderRepository.save(order3); // 메뉴1+순살+치즈볼

        orderMenu1_1 = OrderMenu.builder().order(order3).menu(res_1_menu_1).quantity(1L).build();
        orderMenuRepository.save(orderMenu1_1); // 20000
        orderOption1_1 = OrderOption.builder().orderMenu(orderMenu1_1).optionDetail(res_1_menu_1_option_1_1).build();
        orderOptionRepository.save(orderOption1_1); // 2000
        orderOption1_2 = OrderOption.builder().orderMenu(orderMenu1_1).optionDetail(res_1_menu_1_option_2_1).build();
        orderOptionRepository.save(orderOption1_2); // 5000
    }
}
