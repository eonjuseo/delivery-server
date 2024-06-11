package com.unknown.deliveryserver.domain.restaurant.entity;

import com.unknown.deliveryserver.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Restaurant extends BaseEntity {
    @Comment("가게명")
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Comment("가게 연락처")
    @Column(name = "contact", columnDefinition = "BIGINT")
    private Long contact;
}
