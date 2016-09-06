package com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam;

import lombok.Data;

@Data
public class DataAPIPageInfo {
    private Integer numberOfRows;
    private Integer pageNo;

    public DataAPIPageInfo() {
        numberOfRows = 20;
        pageNo = 1;
    }
}
