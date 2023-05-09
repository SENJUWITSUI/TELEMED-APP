package com.example.telemed;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("users/store")
    Call<Reg> createReg(@Body Reg reg);

    @FormUrlEncoded
    @POST("users/store")
    Call<Reg> createReg (
            @Field("first_name")String fname,
            @Field("middle_name")String mname,
            @Field("last_name")String last_name,
            @Field("suffix")String suffix,
            @Field("birth_date")String birth_date,
            @Field("password")String password,
            @Field("mobile")String mobile,
            @Field("username")String username,
            @Field("sex")String sex
    );
}
