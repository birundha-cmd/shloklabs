package com.example.sholklabs.Apis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://www.json-generator.com/";

    //
//    public static String IMAGE_URL = "http://35.185.96.189:3303/image/";
//    public static final String ApiKey = "1LB2R3A4K5A6S7H8G9";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        } catch (IllegalArgumentException e){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://121.200.52.34")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
