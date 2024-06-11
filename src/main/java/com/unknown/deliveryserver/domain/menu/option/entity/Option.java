package com.unknown.deliveryserver.domain.menu.option.entity;

import com.unknown.deliveryserver.domain.menu.menu.entity.Menu;
import com.unknown.deliveryserver.global.common.entity.BaseEntity;
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
@Table(name = "options")
public class Option extends BaseEntity {
    @Comment("옵션명")
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Comment("메뉴")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", columnDefinition = "BIGINT", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Menu menu;

    @Comment("옵션 필수 선택")
    @Column(name = "is_necessary", columnDefinition = "TINYINT")
    private Boolean isNecessary;
}
