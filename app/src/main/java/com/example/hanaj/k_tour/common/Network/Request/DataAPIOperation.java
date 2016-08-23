package com.example.hanaj.k_tour.common.Network.Request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DataAPIOperation {
    //지역코드조회
    AREA_CODE("areaCode"),

    //서비스분류코드조회
    CATEGORY_CODE("categoryCode"),

    //키워드조회
    SEARCH_KEYWORD("searchKeyword"),

    //행사정보조회
    SEARCH_FESTIVAL("searchFestival"),

    //숙박정보조회
    SEARCH_STAY("searchStay"),

    //지역기반 관광정보조회
    AREABASED_LIST("areaBasedList"),

    //위치기반 관광정보조회
    LOCATIONBASED_LIST("locationBasedList"),

    //소개정보조회
    DETAIL_INTRO("detailIntro"),

    //반복정보조회
    DETAIL_INFO("detailInfo"),

    //이미지정보조회
    DETAIL_IMAGE("detailImage"),

    //공통정보조회
    DETAIL_COMMON("detailCommon");

    @Getter
    private final String value;
}
