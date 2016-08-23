package com.example.hanaj.k_tour.common.Network.Request;

import com.example.hanaj.k_tour.common.AppInfo;

import lombok.Data;

@Data
public class DataAPIParam {
    //Common Parameter (Default value exist)
    private String appName = AppInfo.NAME;
    private String mobileOS = AppInfo.OS;
    private Integer numberOfRows = 10;
    private Integer pageNo = 1;

    //TODO DataAPIOperation Type에 따라서 Parameter가 차이가 있음
    //DataAPIOperation dataAPIOperation;
}
