package com.example.telemed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceAPI {

        @FormUrlEncoded
        @POST("login")
        Call<LoginResponse> checklogin(
                @Field("username") String email,
                @Field("password") String password);

        @GET("services")
        Call<List<Services>> getServices();
}



