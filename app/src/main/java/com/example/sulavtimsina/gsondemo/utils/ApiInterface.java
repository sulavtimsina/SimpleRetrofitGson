package com.example.sulavtimsina.gsondemo.utils;

import com.example.sulavtimsina.gsondemo.model.Product;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //echoJson.php will be appended at the end of BASE_URL in ApiClient.java
    @GET("echoJson.php")
    Call<Product> getProduct();
}
