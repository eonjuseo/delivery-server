package com.unknown.deliveryserver.domain.menu.menu.entity;

import com.unknown.deliveryserver.domain.menu.enumerated.StockStatus;
import com.unknown.deliveryserver.domain.restaurant.entity.Restaurant;
import com.unknown.deliveryserver.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Menu extends BaseEntity {
    @Comment("메뉴명")
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Comment("가게")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", columnDefinition = "BIGINT", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Restaurant restaurant;

    @Comment("상품 가격")
    @Column(name = "menu_price", columnDefinition = "DECIMAL(64, 3)")
    private BigDecimal menuPrice;

    @Comment("메뉴 재고 상태")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(20)")
    private StockStatus status;
}
