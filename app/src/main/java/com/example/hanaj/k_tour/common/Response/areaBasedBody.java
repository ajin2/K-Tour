package com.example.hanaj.k_tour.common.Response;

import java.util.List;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 21..
 */
@Data
public class AreaBasedBody {
    private AreaBasedItemList items;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;
}
