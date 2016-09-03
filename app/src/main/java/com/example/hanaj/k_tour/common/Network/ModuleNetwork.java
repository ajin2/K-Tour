package com.example.hanaj.k_tour.common.Network;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hanaj.k_tour.common.Network.NetworkManager;
import com.example.hanaj.k_tour.common.Network.UTF8StringRequest;

public class ModuleNetwork {
    public void getResponse(int method, String url, Context context, final VolleyCallback callback) {
        StringRequest stringRequest = new UTF8StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccessResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 3, 1.1f));
        NetworkManager.getInstance(context).getRequestQueue().add(stringRequest);
    }

    public interface VolleyCallback {
        void onSuccessResponse(String result);
    }
}
