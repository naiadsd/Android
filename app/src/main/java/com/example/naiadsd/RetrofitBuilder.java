package com.example.naiadsd;

import android.content.Context;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {


    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://us-central1-gelaterianaia-a3f12.cloudfunctions.net/app/";

    private static OkHttpClient.Builder httpClientBuilder = null;

    public static Retrofit getInstance(Context context) {
        if (retrofit == null) {

            httpClientBuilder = new OkHttpClient.Builder()
                    .protocols(Arrays.asList(Protocol.HTTP_1_1))
                    .readTimeout(90, TimeUnit.SECONDS);


            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClientBuilder.build());

            retrofit = builder.build();

        }
        return retrofit;
    }
}