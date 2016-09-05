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
public class DataAPIAreaBasedListParam {
    private DataAPIAppInfo dataAPIAppInfo;
    private DataAPIPageInfo dataAPIPageInfo;
    private DataAPIArrange dataAPIArrange;
    private DataAPIDelimited dataAPIDelimited;
    private Integer contentTypeId;
    private Integer areaCode;
    //Previous Required areaCode
    private Integer sigunguCode;

    private DataAPIClassification dataAPIClassification;

    public DataAPIAreaBasedListParam() {
        dataAPIAppInfo = new DataAPIAppInfo();
        dataAPIPageInfo = new DataAPIPageInfo();
        dataAPIArrange = DataAPIArrange.NAME;
        dataAPIDelimited = DataAPIDelimited.YES;
        contentTypeId = 0;
        areaCode = 0;
        sigunguCode = 0;
        dataAPIClassification = new DataAPIClassification();
    }
}
