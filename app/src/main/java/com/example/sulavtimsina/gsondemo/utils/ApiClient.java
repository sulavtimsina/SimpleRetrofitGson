package com.example.sulavtimsina.gsondemo.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //Base URL should always end with /
    public static final String BASE_URL = "http://10.0.2.2/photogram_app/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }
        return  retrofit;
    }
}
