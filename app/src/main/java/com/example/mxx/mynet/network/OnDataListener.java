package com.example.mxx.mynet.network;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mxx on 2017/8/7.
 */

public interface OnDataListener {
    /**
     * 开始请求
     *
     * @param requestTag 请求标志
     * @param showLoad Load显示
     */
    void onStart(int requestTag, int showLoad);

    /**
     * 请求成功
     *
     * @param requestTag 请求标志
     * @param response   请求返回
     * @param showLoad Load显示
     */
    void requestSuccess(int requestTag, JSONObject response, int showLoad) throws JSONException;

    /**
     * 请求成功
     *
     * @param requestTag 请求标志
     * @param response   请求返回
     * @param showLoad Load显示
     */
    void onSuccess(int requestTag, JSONObject response, int showLoad);

    /**
     * 请求失败
     * @param requestTag    请求标志
     * @param errorResponse 错误请求返回
     * @param showLoad Load显示
     */
    void onFailure(int requestTag, JSONObject errorResponse, int showLoad);


    /**
     * 取消请求监听
     * @param requestTag
     * @param showLoad Load显示
     */
    void onCancel(int requestTag, int showLoad);
}
