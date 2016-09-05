package com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 23..
 */
@Data
public class DataAPIClassification {
    //대분류
    private String cat1;
    //중분류
    private String cat2;
    //소분류
    private String cat3;

    public DataAPIClassification() {
        cat1 = "";
        cat2 = "";
        cat3 = "";
    }
}
