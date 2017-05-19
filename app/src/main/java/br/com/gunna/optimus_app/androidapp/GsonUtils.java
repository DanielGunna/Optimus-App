package br.com.gunna.optimus_app.androidapp;

import com.google.gson.Gson;


/**
 * Created by Daniel on 05/05/17.
 */

public class GsonUtils {

    public  static String getStringFromObject(Object object, Class<?> type){
        Gson gson = new Gson();
        return gson.toJson(object,type);
    }
    public  static Object getObjectFromString(String object, Class<?> type){
        Gson gson = new Gson();
        return gson.fromJson(object,type);
    }


}

