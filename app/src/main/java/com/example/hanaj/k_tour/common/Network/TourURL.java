package com.example.hanaj.k_tour.common.Network;

import android.util.Log;
import android.widget.Toast;

import com.example.hanaj.k_tour.common.AppInfo;
import com.example.hanaj.k_tour.common.Network.Request.APIUrl;
import com.example.hanaj.k_tour.common.Network.Request.DataAPIOperation;
import com.example.hanaj.k_tour.common.Network.Request.Param.DataAPIAreaBasedListParam;

/**
 * Created by Park on 2016-08-31.
 */
public class TourURL {

    public static String areaBasedListURL(DataAPIAreaBasedListParam param) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(APIUrl.DATA_API_PATH);
        stringBuilder.append("/" + DataAPIOperation.AREABASED_LIST.getValue());
        stringBuilder.append("?Servicekey=" + AppInfo.DATA_API_KEY);
        stringBuilder.append("_type=json");
        stringBuilder.append("&numOfRows=" + param.getDataAPIPageInfo().getNumberOfRows());
        stringBuilder.append("&pageNo=" + param.getDataAPIPageInfo().getPageNo());
        stringBuilder.append("&arrange=" + param.getDataAPIArrange().getValue());
        stringBuilder.append("&listYN=" + param.getDataAPIDelimited().getValue());
        //        contentTypeId  타입 ID
        stringBuilder.append("&areaCode=" + param.getAreaCode());
        //        sigunguCode  시군구코드
        //        cat1  대분류
        //        cat2  중분류
        //        cat3  소분류
        stringBuilder.append("&MobileOS=" + param.getDataAPIAppInfo().getMobileOS());
        stringBuilder.append("&MobileApp=" + param.getDataAPIAppInfo().getAppName());

        return stringBuilder.toString();
    }

    public static String execute(String method, String APIUrl, String DataAPIOperation, String serviceKey, DataAPIAreaBasedListParam Parm, String type){
        StringBuilder stringBuilder = new StringBuilder();

        if("GET".equals(method)){
            stringBuilder.append(APIUrl);
            stringBuilder.append("/" + DataAPIOperation);
            stringBuilder.append("?ServiceKey=" + serviceKey);
            stringBuilder.append("&_type=" + type);
            stringBuilder.append("&numOfRows=" + Parm.getDataAPIPageInfo().getNumberOfRows());
            stringBuilder.append("&pageNo=" + Parm.getDataAPIPageInfo().getPageNo());
            stringBuilder.append("&arrange=" + Parm.getDataAPIArrange().getValue());
            stringBuilder.append("&listYN=" + Parm.getDataAPIDelimited().getValue());
            //        contentTypeId  타입 ID
            stringBuilder.append("&areaCode=" + Parm.getAreaCode());
            //        sigunguCode  시군구코드
            //        cat1  대분류
            //        cat2  중분류
            //        cat3  소분류
            stringBuilder.append("&MobileOS=" + Parm.getDataAPIAppInfo().getMobileOS());
            stringBuilder.append("&MobileApp=" + Parm.getDataAPIAppInfo().getAppName());
        }
        /*
        else if ("POST".equals(method)){

        }else{
            return null;
        }
        */
        return stringBuilder.toString();
    }
}
