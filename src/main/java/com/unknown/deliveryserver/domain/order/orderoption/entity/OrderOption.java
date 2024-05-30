package com.unknown.deliveryserver.domain.order.orderoption.entity;

import com.unknown.deliveryserver.domain.menu.optiondetail.entity.OptionDetail;
import com.unknown.deliveryserver.domain.order.ordermenu.entity.OrderMenu;
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
public class OrderOption extends BaseEntity {
    @Comment("주문한 메뉴")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_menu_id", columnDefinition = "BIGINT", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private OrderMenu orderMenu;

    @Comment("옵션 상세")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_detail_id", columnDefinition = "BIGINT", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private OptionDetail optionDetail;
}
