package com.example.hanaj.k_tour.common.Network.Request.Param;

import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIAppInfo;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIArrange;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIPageInfo;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIDelimited;

import java.util.Date;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@Data
public class DataAPISearchFestivalParam {
    private DataAPIAppInfo dataAPIAppInfo;
    private DataAPIPageInfo dataAPIPageInfo;
    private DataAPIArrange dataAPIArrange;
    private DataAPIDelimited dataAPIDelimited;

    //TODO RequestModule에서 YYYYMMDD형식처리 필요
    private Date eventStartDate;
    private Date eventEndDate;
    private Integer areaCode;

    //잘 모름
    private Integer sigunguCode;
}
