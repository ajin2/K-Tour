package com.example.hanaj.k_tour.common.Network;

import android.util.Log;
import android.widget.Toast;

import com.example.hanaj.k_tour.common.Network.Request.Param.DataAPIAreaBasedListParam;

/**
 * Created by Park on 2016-08-31.
 */
public class TourURL {

    StringBuilder stringBuilder = new StringBuilder();

    public String execute(String method, String APIUrl, String DataAPIOperation, String serviceKey, DataAPIAreaBasedListParam Parm, String type){

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
