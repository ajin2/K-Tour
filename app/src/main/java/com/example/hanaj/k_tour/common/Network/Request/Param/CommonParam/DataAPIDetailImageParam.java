package com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@Data
public class DataAPIDetailImageParam {
    private DataAPIAppInfo dataAPIAppInfo;
    private DataAPIPageInfo dataAPIPageInfo;
    private Integer contentId;
    private Integer contentTypeId;
    private boolean imageYN;

    public DataAPIDetailImageParam() {
        dataAPIAppInfo = new DataAPIAppInfo();
        dataAPIPageInfo = new DataAPIPageInfo();
        contentId = 0;
        contentTypeId = 0;
        imageYN = true;
    }
}
