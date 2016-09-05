package com.example.hanaj.k_tour.common.Network.Sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.Request;
import com.example.hanaj.k_tour.R;
import com.example.hanaj.k_tour.common.AppInfo;
import com.example.hanaj.k_tour.common.Network.ModuleNetwork;
import com.example.hanaj.k_tour.common.Network.Request.APIUrl;
import com.example.hanaj.k_tour.common.Network.Request.DataAPIOperation;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIAppInfo;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIArrange;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIDelimited;
import com.example.hanaj.k_tour.common.Network.Request.Param.CommonParam.DataAPIPageInfo;
import com.example.hanaj.k_tour.common.Network.Request.Param.DataAPIAreaBasedListParam;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedJsonResponse;
import com.example.hanaj.k_tour.common.Network.TourURL;
import com.google.gson.Gson;

public class NetworkTestActivity extends AppCompatActivity{

    private ListView networkTestListView;
    private NetworkTestListViewAdapter networkTestListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_test);

        networkTestListView = (ListView) findViewById(R.id.network_Test_listView);
        networkTestListViewAdapter = new NetworkTestListViewAdapter(getApplicationContext());
        networkTestListView.setAdapter(networkTestListViewAdapter);

        /*******************************************************************************************************
         * URL 및 ModuleNetwork - getResponse 설명
         *
         * Sample - common > Network > Sample > NetworkTestActivity
         *
         * URL
         *  - tourURL.execute() 호출
         *  - param
         *      1. String method - GET, POST, PUT, DELETE...
         *      2. String APIUrl - API호출 URL
         *      3. String DataAPIOperation - 상세기능 (지역기반 관광정보조회, 행사정보조회, 키워드조회 등...)
         *      4. String serviceKey - API KEY
         *      5. DataAPIAreaBasedListParam Parm - 요청메시지(Request Parameter)
         *      6. String type - json, xml...
         *
         * moduleNetwork
         *  - moduleNetwork.getResponse() 호출
         *  - param
         *      1. Request.Method.GET - 효철 타입(GET, POST, PUT, DELETE)
         *      2. String url - tourURL.execute()로 만들어진 URL
         *      3. getApplicationContext() - Application의 LifeCycle에 해당하는 Context
         *      4. new ModuleNetwork.VolleyCallback()
         *          - Return받은 response에 대해서 로직 구현
         *          * onSuccessResponse메소드가 Interface이므로 구현 필수
         *******************************************************************************************************/
        DataAPIAreaBasedListParam param = new DataAPIAreaBasedListParam();
        param.setAreaCode(35);

        String url = TourURL.execute("GET", APIUrl.DATA_API_PATH, DataAPIOperation.AREABASED_LIST.getValue(), AppInfo.DATA_API_KEY, param, "json");
//        String url = TourURL.areaBasedListURL(param);

        ModuleNetwork moduleNetwork = new ModuleNetwork();

        moduleNetwork.getResponse(Request.Method.GET, url, getApplicationContext(), new ModuleNetwork.VolleyCallback() {
            @Override
            public void onSuccessResponse(String response) {
                Gson gson = new Gson();
                AreaBasedJsonResponse areaBasedJsonResponse = gson.fromJson(response, AreaBasedJsonResponse.class);

                networkTestListViewAdapter.addNetworkTestDataList(areaBasedJsonResponse);
                networkTestListViewAdapter.notifyDataSetChanged();
            }
        });
    }
}
