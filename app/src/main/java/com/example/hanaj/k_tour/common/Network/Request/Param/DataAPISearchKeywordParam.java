package com.example.hanaj.k_tour.common.Network.Request.Param;

import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIAppInfo;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIArrange;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIClassification;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIPageInfo;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIDelimited;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@Data
public class DataAPISearchKeywordParam {
    private DataAPIAppInfo dataAPIAppInfo;
    private DataAPIPageInfo dataAPIPageInfo;
    private DataAPIArrange dataAPIArrange;
    private DataAPIDelimited dataAPIDelimited;
    private Integer contentTypeId;
    //TODO Request Module에서 Encoding 처리해야함
    private String keyword;
    private Integer areaCode;

    //잘 모름.
    private Integer sigunguCode;
    DataAPIClassification dataAPIClassification;
}
