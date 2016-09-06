package com.example.hanaj.k_tour.common.MainSearch;

import com.example.hanaj.k_tour.common.Network.Request.Param.DataAPIAreaBasedListParam;

/**
 * Created by hanaj on 2016-09-05.
 */
public class MainSearchURL {

    StringBuilder stringBuilder = new StringBuilder();

    public String execute(String method, String APIUrl, String DataAPIOperation, String serviceKey, DataAPIAreaBasedListParam Param, String type) {

        if ("GET".equals(method)) {
            stringBuilder.append(APIUrl);
            stringBuilder.append("/" + DataAPIOperation);
            stringBuilder.append("?ServiceKey=" + serviceKey);
            stringBuilder.append("&_type=" + type);
            stringBuilder.append("&numOfRows=" + Param.getDataAPIPageInfo().getNumberOfRows());
            stringBuilder.append("&pageNo=" + Param.getDataAPIPageInfo().getPageNo());
            stringBuilder.append("&arrange=" + Param.getDataAPIArrange().getValue());
            stringBuilder.append("&listYN=" + Param.getDataAPIDelimited().getValue());
            //        contentTypeId  타입 ID
            stringBuilder.append("&areaCode=" + Param.getAreaCode());
            //        sigunguCode  시군구코드
            //        cat1  대분류
            //        cat2  중분류
            //        cat3  소분류
            stringBuilder.append("&MobileOS=" + Param.getDataAPIAppInfo().getMobileOS());
            stringBuilder.append("&MobileApp=" + Param.getDataAPIAppInfo().getAppName());
        }

        return stringBuilder.toString();
    }
}
