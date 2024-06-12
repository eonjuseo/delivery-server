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
    private int page; // 현재 슬라이드 번호
    private int size; // 현재 페이지 크기
//    private Long count;
    private boolean hasNext;

    public static PageInfo of(Slice slice) {
        return PageInfo.builder()
                .size(slice.getSize())
                .page(slice.getNumber())
                .hasNext(slice.hasNext())
                .build();
    }

    public static <T> Slice<T> checkLastPage(Pageable pageable, List<T> results) {
        boolean hasNext = false;

        if (results.size() > pageable.getPageSize()) {
            hasNext = true;
            results.remove(pageable.getPageSize());
        }

        return new SliceImpl<>(results, pageable, hasNext);
    }
}
