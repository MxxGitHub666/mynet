package com.example.mxx.mynet.network.utils;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.HashMap;

/**
 * Created by mxx on 2017/8/7.
 */

public class JsonUtils {

    /**
     * hashMap转JSON
     *
     * @param hashMap
     * @return
     */
    public static JSONStringer createJSON(HashMap<String, Object> hashMap) {
        JSONStringer jsonText = new JSONStringer();
        try {
            jsonText.object();
            for (HashMap.Entry<String, Object> entry : hashMap.entrySet()) {
                jsonText.key(entry.getKey());
                jsonText.value((entry.getValue()+"").replace("'", "‘"));   // 替换英文单引号，后台数据库英文单引号冲突
            }
            jsonText.endObject();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonText;
    }

}
