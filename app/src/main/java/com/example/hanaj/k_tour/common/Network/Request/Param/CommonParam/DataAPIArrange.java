package com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@RequiredArgsConstructor
public enum DataAPIArrange {

    //제목순
    NAME("A"),
    //조회순
    MOST("B"),
    //수정일순
    MODIFIED("C"),
    //생성일순
    CREATED("D"),
    //거리순
    DIST("E");

    @Getter
    private final String value;
}
