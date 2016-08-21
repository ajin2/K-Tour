package com.example.hanaj.k_tour.common.Network.Response;

import lombok.Data;

/**
 * Created by alphaposter on 2016. 8. 21..
 */
@Data
public class AreaBasedResponse {
    
    //TODO 향후 공통 Module로 빼면서 제거작업 필요.
    private AreaBasedHeader header;
    private AreaBasedBody body;
}
