package com.example.sulavtimsina.gsondemo.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sulavtimsina.gsondemo.R;
import com.example.sulavtimsina.gsondemo.model.Product;
import com.example.sulavtimsina.gsondemo.utils.ApiClient;
import com.example.sulavtimsina.gsondemo.utils.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonfromLocalhostApi extends AppCompatActivity {

    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonfrom_localhost_api);

        tvDisplay = findViewById(R.id.tvSecond);

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Product> call = apiInterface.getProduct();

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(@NonNull Call<Product> call, Response<Product> response) {
                int itemId = response.body().getItemId();
                String upc = response.body().getUpc();
                tvDisplay.setText("Item id: "+itemId+" UPC: "+upc);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                tvDisplay.setText(t.toString());
            }
        });

    }
}
