package com.example.hanaj.k_tour.common.Tour;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

/**
 * Created by hanaj on 2016-08-30.
 */

//TODO  이 파일이 왜 있어야 하는지 Slack에 남겨주세요. UTF8StringRequest와 중복코드.
public class TourUTF8StringRequest extends StringRequest {

    public TourUTF8StringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            return Response.success(new String(response.data, "UTF-8"),  HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();;

            return Response.error(new ParseError(e));
        }
    }
}
