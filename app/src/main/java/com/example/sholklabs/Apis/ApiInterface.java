package com.example.sholklabs.Apis;

import com.example.sholklabs.model.ListObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/json/get/cqRrpIGVVe?indent=2")
    Call<ListObject>listResponse();
}
