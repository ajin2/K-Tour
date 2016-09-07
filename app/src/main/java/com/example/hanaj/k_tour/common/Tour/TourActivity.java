package com.example.hanaj.k_tour.common.Tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hanaj.k_tour.MainActivity;
import com.example.hanaj.k_tour.R;
import com.example.hanaj.k_tour.common.Network.NetworkManager;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedJsonResponse;
import com.example.hanaj.k_tour.common.Network.UTF8StringRequest;
import com.google.gson.Gson;

/**
 * Created by hanaj on 2016-08-27.
 */
public class TourActivity extends AppCompatActivity {

    private ListView tourMainListView;
    private TourListViewAdapter tourListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tourMainListView = (ListView) findViewById(R.id.tour_main_listView);
        tourListViewAdapter = new TourListViewAdapter(getApplicationContext());
        tourMainListView.setAdapter(tourListViewAdapter);
        requestTourData();
    }

    private void requestTourData(){

        //TODO request Version Up 바람. R.string.xxxx 접근하지 말 것. 곧 삭제 예정.
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

        StringRequest stringRequest = new UTF8StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                AreaBasedJsonResponse areaBasedJsonResponse = gson.fromJson(response, AreaBasedJsonResponse.class);

                tourListViewAdapter.addTourDataList(areaBasedJsonResponse);
                tourListViewAdapter.notifyDataSetChanged();
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
