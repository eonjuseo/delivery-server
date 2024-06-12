package com.unknown.deliveryserver.global.common.response;

import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class PageInfo {
    private int page;
    private int size;
    private Long count;
    private boolean isLast;

    public static PageInfo of(Slice slice) {
        return PageInfo.builder()
                .size(slice.getPageable().getPageSize())
                .page(slice.getPageable().getPageNumber())
                .isLast(slice.isLast())
                .build();
    }

    public static <T> Slice<T> checkLastPage(Pageable pageable, List<T> results) {
        boolean isLast = true;

        if (results.size() > pageable.getPageSize()) {
            isLast = false;
            results.remove(pageable.getPageSize());
        }

        return new SliceImpl<>(results, pageable, isLast);
    }
}
