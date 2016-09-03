package com.example.hanaj.k_tour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hanaj.k_tour.common.Network.NetworkManager;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedJsonResponse;
import com.example.hanaj.k_tour.common.Network.Sample.NetworkTestActivity;
import com.example.hanaj.k_tour.common.Network.Sample.NetworkTestListViewAdapter;
import com.example.hanaj.k_tour.common.Network.UTF8StringRequest;
import com.example.hanaj.k_tour.common.Tour.TourListViewAdapter;
import com.google.gson.Gson;

public class MainActivity extends Activity {

    private ListView networkTestListView;
    private ListView tourListView;
    private NetworkTestListViewAdapter networkTestListViewAdapter;
    private TourListViewAdapter tourListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button networkTestBtn = (Button)findViewById(R.id.network_test_btn);
        ListView listView = (ListView) findViewById(R.id.tour_main_listView);

        tourListViewAdapter = new TourListViewAdapter(getApplicationContext());
        listView.setAdapter(tourListViewAdapter);
        requestTestData();

        networkTestListViewAdapter = new NetworkTestListViewAdapter(getApplicationContext());
        listView.setAdapter(networkTestListViewAdapter);
        requestTestData();

        networkTestBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkTestActivity.class);
                startActivity(intent);
            }
        });
    }

    private void requestTestData() {

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

                networkTestListViewAdapter.addNetworkTestDataList(areaBasedJsonResponse);
                networkTestListViewAdapter.notifyDataSetChanged();
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