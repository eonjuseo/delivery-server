package com.unknown.deliveryserver.domain.menu.optiondetail.entity;

import com.unknown.deliveryserver.domain.menu.enumerated.StockStatus;
import com.unknown.deliveryserver.domain.menu.util.StockStatusConverter;
import com.unknown.deliveryserver.domain.menu.option.entity.Option;
import com.unknown.deliveryserver.global.entity.BaseEntity;
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
public class OptionDetail extends BaseEntity {
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Comment("옵션")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id", columnDefinition = "BIGINT", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Option option;

    @Comment("옵션 가격")
    @Column(name = "option_price", columnDefinition = "DECIMAL(64, 3)")
    private BigDecimal optionPrice;

    @Comment("옵션 재고 상태")
    @Column(name = "status", columnDefinition = "VARCHAR(20)")
    @Convert(converter = StockStatusConverter.class)
    private StockStatus status;
}
