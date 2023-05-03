package com.example.telemed;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceAPI {

        @FormUrlEncoded
        @POST("login")
        Call<LoginResponse> checklogin(
                @Field("email") String email,
                @Field("password") String password);

//        @POST("logout")
//        Call<LogoutResponse> logout();


//        @POST("login")
//        Call<String> login (@Header("Authorization") String authToken);
//@POST("login")
//Call<LoginResponse> checklogin(@Query("Email") String email, @Query("password") String password);
}



