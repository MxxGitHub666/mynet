package com.example.mxx.mynet;

import android.view.View;

import com.example.mxx.mynet.network.HttpManager;
import com.example.mxx.mynet.network.OnDataListener;
import com.example.mxx.mynet.network.utils.EnDecryptUtlis;
import com.example.mxx.mynet.network.utils.JsonUtils;
import com.example.mxx.mynet.network.utils.Md5Utils;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;

/**
 * Created by mxx on 2017/8/7.
 */

public class RequestAction {

    HttpManager httpManager = HttpManager.getIntent();
    public static String randomCode;

    public static RequestParams getParams(String func, HashMap<String, Object> hashMap){

        randomCode = Md5Utils.Md5("p_login_Version2.0.0");
        RequestParams params = new RequestParams();
        params.add("func", func);
        params.add("words", randomCode + EnDecryptUtlis.aesEncrypt(JsonUtils.createJSON(hashMap).toString(), randomCode));
        return params;
    }

    public static int TAG_LOGIN  = 1;
    public RequestHandle login(OnDataListener onDataListener, String phone, String yanzhengma){
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("账号", "");
        hashMap.put("手机号", phone);
        hashMap.put("验证码",yanzhengma);
        hashMap.put("随机码", Md5Utils.Md5("p_login_Version2.0.0"));
        hashMap.put("phoneid", "159148754555");
        return httpManager.doPost(TAG_LOGIN,getParams("p_login_Version2.0.0",hashMap), onDataListener,0);
    }




}
