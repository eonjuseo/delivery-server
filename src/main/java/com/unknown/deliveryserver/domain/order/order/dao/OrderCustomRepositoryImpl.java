package com.unknown.deliveryserver.domain.order.order.dao;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.unknown.deliveryserver.domain.order.order.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.unknown.deliveryserver.domain.order.order.entity.QOrder.order;

@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Order> findByRestaurantId(Pageable pageable, Long restaurantId) {
        BooleanBuilder builder = new BooleanBuilder();

        if (restaurantId != null) {
            builder.and(order.restaurant.id.eq(restaurantId));
        }

        List<Order> fetch = jpaQueryFactory
                .selectFrom(order)
                .where(builder)
                .orderBy(order.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> total = jpaQueryFactory
                .select(order.count())
                .from(order)
                .where(builder);

        return PageableExecutionUtils.getPage(fetch, pageable, total::fetchOne);
    }
}
