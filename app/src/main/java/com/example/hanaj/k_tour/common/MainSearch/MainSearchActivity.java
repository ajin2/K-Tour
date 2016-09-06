package com.example.hanaj.k_tour.common.MainSearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hanaj.k_tour.R;
import com.example.hanaj.k_tour.common.Network.NetworkManager;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedJsonResponse;
import com.example.hanaj.k_tour.common.Network.UTF8StringRequest;
import com.google.gson.Gson;

/**
 * Created by hanaj on 2016-09-05.
 */
public class MainSearchActivity extends AppCompatActivity {

    private EditText mainSearchEditText;
    private ListView mainSearchListView;
    private MainSearchListViewAdapter mainSearchListViewAdapter;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main_seach_listview);

        mainSearchEditText = (EditText) findViewById(R.id.main_search_EditText);
        mainSearchListView = (ListView) findViewById(R.id.main_Search_ListView);

        mainSearchListViewAdapter = new MainSearchListViewAdapter(getApplicationContext());
        mainSearchListView.setAdapter(mainSearchListViewAdapter);
        requestMainSearchData();
    }

    private void requestMainSearchData() {

        StringBuilder stringBuilder = new StringBuilder();

        String path = getResources().getString(R.string.searchKeyword_URL);
        stringBuilder.append(path);

        String serviceKey = getResources().getString(R.string.Data_API_Key);
        stringBuilder.append("?ServiceKey=" + serviceKey);

        //Todo keyword EDIT로 받아오기
        String keyword = "mainSearchEditText";
        stringBuilder.append("&keyword=" + keyword);

        String mobileOS = getResources().getString(R.string.MobileOS);
        stringBuilder.append("&MobileOS=" + mobileOS);

        String mobileApp = getResources().getString(R.string.app_name);
        stringBuilder.append("&MobileApp=" + mobileApp);

        stringBuilder.append("&_type=json");

        String url = stringBuilder.toString();

        StringRequest stringRequest = new UTF8StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                AreaBasedJsonResponse areaBasedJsonResponse = gson.fromJson(response, AreaBasedJsonResponse.class);

                mainSearchListViewAdapter.addMainSearchDataList(areaBasedJsonResponse);
                mainSearchListViewAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 3, 1.1f));
        NetworkManager.getInstance(getApplicationContext()).getRequestQueue().add(stringRequest);
    }
}
