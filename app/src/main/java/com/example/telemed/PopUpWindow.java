package com.example.telemed;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PopUpWindow extends Activity {

//    private Spinner serbisyo_spinner, hospital_spinner;
//    private List<Services> ServicesList = new ArrayList<>();
//    private static String API_BASE_URL = "http://10.20.98.230:8080/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);

//        serbisyo_spinner = findViewById(R.id.spin1);
//        hospital_spinner = findViewById(R.id.spinn);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(API_BASE_URL)  //Change server URL
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        InterfaceAPI interfaceAPI = retrofit.create(InterfaceAPI.class);
//
//        Call<List<Services>> call = interfaceAPI.getServices();
//        call.enqueue(new Callback<List<Services>>() {
//            @Override
//            public void onResponse(Call<List<Services>> call, Response<List<Services>> response) {
//                if (response.isSuccessful()) {
//                    ServicesList = response.body();
//                    ArrayAdapter<Services> adapter = new ArrayAdapter<>(PopUpWindow.this,
//                            android.R.layout.simple_spinner_item, ServicesList);
//                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    serbisyo_spinner.setAdapter(adapter);
//                }
//            }
//            @Override
//            public void onFailure(Call<List<Services>> call, Throwable t) {
//                Log.e("TAG", "Response: " + t.getMessage());
//            }
//        });
    }
}