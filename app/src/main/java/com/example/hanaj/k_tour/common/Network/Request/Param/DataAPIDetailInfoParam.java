package com.example.hanaj.k_tour.common.Network.Request.Param;

import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIAppInfo;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@Data
public class DataAPIDetailInfoParam {
    private DataAPIAppInfo dataAPIAppInfo;
    private Integer contentId;
    private Integer contentTypeId;
    private boolean detailYN = false;
}
