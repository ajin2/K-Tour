package com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam;

import com.example.hanaj.k_tour.common.AppInfo;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@Data
public class DataAPIAppInfo {
    //Default Value
    private final String appName = AppInfo.NAME;
    private final String mobileOS = AppInfo.OS;
}
