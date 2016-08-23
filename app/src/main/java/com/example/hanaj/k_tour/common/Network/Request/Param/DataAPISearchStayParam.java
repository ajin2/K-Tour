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
public class DataAPISearchStayParam {
    private DataAPIAppInfo dataAPIAppInfo;
    private DataAPIPageInfo dataAPIPageInfo;
    private DataAPIArrange dataAPIArrange;
    private DataAPIDelimited dataAPIDelimited;
    private Integer contentTypeId;
    private Integer hanOk = 1;
    private Integer benikia = 1;
    private Integer goodStay = 1;
    private Integer areaCode;
    //잘모름
    private Integer sigunguCode;

}
