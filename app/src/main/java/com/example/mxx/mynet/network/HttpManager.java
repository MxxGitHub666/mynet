package com.example.mxx.mynet.network;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * Created by mxx on 2017/8/5.
 */

public class HttpManager {

    // 服务器地址
    public static String URL = "http://192.168.0.209:9529/api.post"; // 测试
//    private static String URL;
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static HttpManager httpManager;

    public static void init(String url) {
        URL = url;
    }

    public static HttpManager getIntent(){
        if(httpManager==null){
            httpManager = new HttpManager();
        }
        return httpManager;
    }

    public static RequestHandle doPost(final int requestTag, RequestParams params, final OnDataListener onDataListener, final int showLoad){

        client.setMaxRetriesAndTimeout(0,5000);
        return client.post(URL,params,new JsonHttpResponseHandler(){
            @Override
            public void onStart() {
                super.onStart();
                onDataListener.onStart(requestTag,showLoad);
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                onDataListener.onSuccess(requestTag,response,showLoad);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                onDataListener.onFailure(requestTag, errorResponse, showLoad);
            }

            @Override
            public void onCancel() {
                super.onCancel();
                onDataListener.onCancel(requestTag,showLoad);
            }
        });

    }
}
