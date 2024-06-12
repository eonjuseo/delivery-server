package com.unknown.deliveryserver.global.common.response;

import lombok.*;
import org.springframework.data.domain.Slice;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class PageResponse<T> {
    private T data;
    private PageInfo pageInfo;
    private Long lastOrderId;

    public static <T> PageResponse of(Slice<T> slice, Long lastOrderId) {
        return PageResponse.builder()
                .data(slice.getContent())
                .pageInfo(PageInfo.of(slice))
                .lastOrderId(lastOrderId)
                .build();
    }
}