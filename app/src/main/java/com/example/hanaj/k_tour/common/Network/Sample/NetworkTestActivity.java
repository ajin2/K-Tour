package com.example.hanaj.k_tour.common.Network.Sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hanaj.k_tour.R;
import com.example.hanaj.k_tour.common.Network.NetworkManager;
import com.example.hanaj.k_tour.common.Network.Response.AreaBasedJsonResponse;
import com.google.gson.Gson;

/**
 * Created by alphaposter on 2016. 8. 21..
 */
public class NetworkTestActivity extends AppCompatActivity{

    private ListView networkTestListView;
    private NetworkTestListViewAdapter networkTestListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_test);

        networkTestListView = (ListView)findViewById(R.id.network_Test_listView);
        networkTestListViewAdapter = new NetworkTestListViewAdapter(getApplicationContext());
        networkTestListView.setAdapter(networkTestListViewAdapter);
        requestTestData();
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
