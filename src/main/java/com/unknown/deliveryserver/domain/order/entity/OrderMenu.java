package com.unknown.deliveryserver.domain.order.entity;

import com.unknown.deliveryserver.domain.menu.menu.entity.Menu;
import com.unknown.deliveryserver.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderMenu extends BaseEntity {
    @Comment("주문")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", columnDefinition = "BIGINT", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Order order;

    @Comment("메뉴")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", columnDefinition = "BIGINT", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Menu menu;

    @Comment("수량")
    @Column(name = "quantity", columnDefinition = "BIGINT")
    private Long quantity;
}
