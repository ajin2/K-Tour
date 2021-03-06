package com.example.hanaj.k_tour.common.Network.Request.Param;

import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIAppInfo;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIArrange;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIPageInfo;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIDelimited;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@Data
public class DataAPILocationBasdListParam {
    private DataAPIAppInfo dataAPIAppInfo;
    private DataAPIPageInfo dataAPIPageInfo;
    private DataAPIArrange dataAPIArrange;
    private DataAPIDelimited dataAPIDelimited;
    private Integer contentTypeId;
    private Double mapX;
    private Double mapY;
    private Integer radius;
}
