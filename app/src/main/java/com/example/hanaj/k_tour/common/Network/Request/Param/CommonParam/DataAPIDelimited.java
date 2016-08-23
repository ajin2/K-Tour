package com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@RequiredArgsConstructor
public enum DataAPIDelimited {
    //목록 구분으로
    YES("Y"),
    //갯수로
    NO("N");

    @Getter
    private final String value;
}
