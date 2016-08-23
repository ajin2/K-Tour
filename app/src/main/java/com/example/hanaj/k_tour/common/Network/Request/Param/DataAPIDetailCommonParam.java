package com.example.hanaj.k_tour.common.Network.Request.Param;

import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIAppInfo;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@Data
public class DataAPIDetailCommonParam {
    private DataAPIAppInfo dataAPIAppInfo;
    private Integer contentId;
    private Integer contentTypeId;
    private boolean defaultYN = false;
    private boolean firstImageYN = false;
    private boolean areacodeYN = false;
    private boolean catcodeYN = false;
    private boolean addrinfoYN = false;
    private boolean mapinfoYN = false;
    private boolean overviewYN = false;
}
