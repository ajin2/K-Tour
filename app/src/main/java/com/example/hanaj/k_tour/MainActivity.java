package com.example.hanaj.k_tour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hanaj.k_tour.common.MainSearch.MainSearchActivity;
import com.example.hanaj.k_tour.common.Network.NetworkManager;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedJsonResponse;
import com.example.hanaj.k_tour.common.Network.Sample.NetworkTestActivity;
import com.example.hanaj.k_tour.common.Network.UTF8StringRequest;
import com.example.hanaj.k_tour.common.Tour.TourData;
import com.example.hanaj.k_tour.common.Tour.TourDetailPage;
import com.example.hanaj.k_tour.common.Tour.TourListViewAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView tourListView;
    private EditText mainSearchEditText;
    private TourListViewAdapter tourListViewAdapter;

    private ArrayList<TourData> tourDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button main_search_btn = (Button)findViewById(R.id.main_search_btn);
        Button networkTestBtn = (Button)findViewById(R.id.network_test_btn);
        tourListView = (ListView) findViewById(R.id.tour_main_listView);

        tourListViewAdapter = new TourListViewAdapter(getApplicationContext());
        tourListView.setAdapter(tourListViewAdapter);
        requestTourData();

        tourListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    // 스크롤 끝에 도달.
                    if (tourListView.getLastVisiblePosition() >= tourListView.getCount() - 5) {
                        requestTourData();

                    }
                }
            }
        });

        main_search_btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainSearchActivity.class);
                startActivity(intent);
            }
        });
//TODO YoutubeSample에서는 버튼의 생성과 관리를 따로 Method를 뺏는데 왜 그랬을지 생각해보세요.
        networkTestBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkTestActivity.class);
                startActivity(intent);
            }
        });

        tourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String title = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, TourDetailPage.class);
                startActivity(intent);
            }
        });

    }


    private void requestTourData() {

        StringBuilder stringBuilder = new StringBuilder();

        String path = getResources().getString(R.string.areaBasedList_URL);
        stringBuilder.append(path);

        String serviceKey = getResources().getString(R.string.Data_API_Key);
        stringBuilder.append("?ServiceKey=" + serviceKey);

        String areaCode = "34";
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