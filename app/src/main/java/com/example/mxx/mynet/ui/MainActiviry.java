package com.example.mxx.mynet.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mxx.mynet.R;
import com.example.mxx.mynet.RequestAction;
import com.example.mxx.mynet.network.HttpManager;
import com.example.mxx.mynet.network.OnDataListener;
import com.example.mxx.mynet.network.utils.EnDecryptUtlis;
import com.example.mxx.mynet.network.utils.JsonUtils;
import com.example.mxx.mynet.network.utils.Md5Utils;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by mxx on 2017/8/7.
 */

public class MainActiviry extends Activity implements OnDataListener{
    private Button btn_dianji;
    protected ArrayList<RequestHandle> requestHandleArrayList = new ArrayList<>();
    private RequestAction requestAction= new RequestAction();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btn_dianji = (Button) findViewById(R.id.btn_anniu);
        btn_dianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestHandleArrayList.add(requestAction.login(MainActiviry.this,"","123456"));
            }
        });
    }

    @Override
    public void onStart(int requestTag, int showLoad) {

    }

    @Override
    public void requestSuccess(int requestTag, JSONObject response, int showLoad) throws JSONException {

    }

    @Override
    public void onSuccess(int requestTag, JSONObject response, int showLoad) {
        Log.e("onSuccess",response.toString()+"=====");

    }

    @Override
    public void onFailure(int requestTag, JSONObject errorResponse, int showLoad) {

    }

    @Override
    public void onCancel(int requestTag, int showLoad) {

    }
}
