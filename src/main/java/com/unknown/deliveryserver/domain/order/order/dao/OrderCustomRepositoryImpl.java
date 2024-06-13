package com.unknown.deliveryserver.domain.order.order.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.unknown.deliveryserver.domain.order.order.entity.Order;
import com.unknown.deliveryserver.global.common.response.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.time.LocalDate;
import java.util.List;

import static com.unknown.deliveryserver.domain.order.order.entity.QOrder.order;

@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Slice<Order> findByRestaurantId(Pageable pageable, Long restaurantId, Long cursorId, LocalDate start, LocalDate end) {
        BooleanExpression conditions = order.restaurant.id.eq(restaurantId);

        if (cursorId != null) {
            conditions = conditions.and(order.id.lt(cursorId));
        }

        if (start != null) { // start 날짜가 '00:00:00' 이후이거나 같은 지 확인
            conditions = conditions.and(order.createdAt.goe(start.atStartOfDay()));
        }
        if (end != null) { // end 날짜가 '00:00:00' 보다 작은 지 확인
            conditions = conditions.and(order.createdAt.lt(end.plusDays(1).atStartOfDay()));
        }

        List<Order> fetch = jpaQueryFactory
                .selectFrom(order)
                .where(conditions)
                .orderBy(order.id.desc())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        return PageInfo.checkLastPage(pageable, fetch);
    }
}
