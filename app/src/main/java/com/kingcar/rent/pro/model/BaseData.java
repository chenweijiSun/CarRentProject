package com.kingcar.rent.pro.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cwj on 16/7/16.
 */
public class BaseData implements Serializable {
    private JSONObject resultObject;
    private JSONArray resultArray;
    private String result;
    private int code;
    private String message;
    private int total;
    private boolean isRedBag;

    public boolean isRedBag() {
        return isRedBag;
    }

    public int getTotal() {
        return total;
    }

    public void setRedBag(boolean redBag) {
        isRedBag = redBag;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getStringData(String value) {
        try {
            return getResultJson().optString(value);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getResultJson() throws JSONException {
        if (resultObject == null) {
            return new JSONObject(result);
        }
        return resultObject;
    }

    public JSONArray getResultArray() throws JSONException {
        if (resultArray == null) {
            return new JSONArray(result);
        }
        return resultArray;
    }

    public <T> T getResultInfo(Class<T> infoClass) {
        return new Gson().fromJson(result, infoClass);
    }

    public <T> T getItemInfo(String param, Class<T> infoClass) {
        try {
            JSONObject jsonObject = getResultJson();
            return new Gson().fromJson(jsonObject.optString(param), infoClass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> getDataList(String param, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            if (param == null) {
                Gson gson = new Gson();
                JsonArray arry = new JsonParser().parse(result).getAsJsonArray();
                for (JsonElement jsonElement : arry) {
                    list.add(gson.fromJson(jsonElement, cls));
                }
            } else {
                String optResult = getResultJson().optString(param);
                Gson gson = new Gson();
                JsonArray arry = new JsonParser().parse(optResult).getAsJsonArray();
                for (JsonElement jsonElement : arry) {
                    list.add(gson.fromJson(jsonElement, cls));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void setResult(String result) {
        this.result = result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
