package com.example.hanaj.k_tour.common.MainSearch;

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
import com.google.gson.Gson;

/**
 * Created by hanaj on 2016-09-05.
 */
public class MainSearchActivity extends AppCompatActivity {

    private ListView mainSearchListView;
    private MainSearchListViewAdapter mainSearchListViewAdapter;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main_seach_listview);

        mainSearchListView = (ListView) findViewById(R.id.main_Search_ListView);
        mainSearchListViewAdapter = new MainSearchListViewAdapter(getApplicationContext());
        mainSearchListView.setAdapter(mainSearchListViewAdapter);

        DataAPIAreaBasedListParam Param = new DataAPIAreaBasedListParam();
        MainSearchURL mainSearchURL = new MainSearchURL();
        DataAPIAppInfo dataAPIAppInfo = new DataAPIAppInfo();
        DataAPIPageInfo dataAPIPageInfo = new DataAPIPageInfo();

        Param.setDataAPIAppInfo(dataAPIAppInfo);
        Param.setDataAPIPageInfo(dataAPIPageInfo);
        Param.setDataAPIArrange(DataAPIArrange.MOST);
        Param.setDataAPIDelimited(DataAPIDelimited.YES);

        String url = mainSearchURL.execute("GET", APIUrl.DATA_API_PATH, DataAPIOperation.SEARCH_KEYWORD.getValue(), AppInfo.DATA_API_KEY, Param, "json");

        ModuleNetwork moduleNetwork = new ModuleNetwork();

        moduleNetwork.getResponse(Request.Method.GET, url, getApplicationContext(), new ModuleNetwork.VolleyCallback() {
            @Override
            public void onSuccessResponse(String response) {
                Gson gson = new Gson();
                AreaBasedJsonResponse areaBasedJsonResponse = gson.fromJson(response, AreaBasedJsonResponse.class);

                mainSearchListViewAdapter.addMainSearchDataList(areaBasedJsonResponse);
                mainSearchListViewAdapter.notifyDataSetChanged();
            }
        });
    }



    private void requestMainSearchData() {

        StringBuilder stringBuilder = new StringBuilder();

        String path = getResources().getString(R.string.areaBasedList_URL);
        stringBuilder.append(path);

        String serviceKey = getResources().getString(R.string.Data_API_Key);
        stringBuilder.append("?ServiceKey=" + serviceKey);

        String areaCode = "35";
        stringBuilder.append("&areaCode=" + areaCode);

        String mobileOS = getResources().getString(R.string.MobileOS);
        stringBuilder.append("&MobileOS=" + mobileOS);

        String mobileApp = getResources().getString(R.string.app_name);
        stringBuilder.append("&MobileApp=" + mobileApp);

        stringBuilder.append("&_type=json");

        String url = stringBuilder.toString();

    }

}
