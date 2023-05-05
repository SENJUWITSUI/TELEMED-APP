package com.example.telemed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("services")
    Call<List<Post>> listRepos();

    @GET("hospitals")
    Call<List<Post>> listRepos2();
}
