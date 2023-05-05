package com.example.telemed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class User_Interface extends AppCompatActivity {
    private static String BASE_URL = "http://10.20.101.23:8080/api/";
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Myviewpager myviewpager;

    private Button button;
    TextView txt;
    Dialog dialog;

    Spinner spinner;
    String[] data = {"Option 1", "Change Password", "LogOut"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);

        tabLayout = findViewById(R.id.tabs);
        viewPager2 = findViewById(R.id.view1);
        myviewpager = new Myviewpager(this);
        viewPager2.setAdapter(myviewpager);

        dialog = new Dialog(User_Interface.this);
        dialog.setContentView(R.layout.activity_pop_up_window);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        Button hindi = dialog.findViewById(R.id.btn_hindi);
        Button ipasa = dialog.findViewById(R.id.btn_ipasa);

        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmain();
            }
        });

        txt = (TextView) dialog.findViewById(R.id.exit);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });


        ipasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencalendar();

            }
        });

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(User_Interface.this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = data[position];
                if (selectedItem.equals("LogOut")) {
                    // Perform logout action here
                    Toast.makeText(getApplicationContext(), "Logout Successfully", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(User_Interface.this,Login.class));
                            finish();
                        }
                    },700);
                    // You can also navigate to a logout screen or clear the user's session data here

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        //CREATE SCHEDULE DIALOG CODE
            //Populate Service Spinner
        Spinner service_spinner = dialog.findViewById(R.id.spin1);
        Spinner hospitals_spinner = dialog.findViewById(R.id.spinn);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.listRepos();
        Call<List<Post>> call2 = jsonPlaceHolderApi.listRepos2();
        call.enqueue(new Callback<List<Post>>(){
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response){
                List<Post> posts = response.body();

                List<String> spinnerItems = new ArrayList<>();
                for(Post post : posts){
                    spinnerItems.add(post.getServiceName());
                }
                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(User_Interface.this,
                        android.R.layout.simple_spinner_item, spinnerItems);
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                service_spinner.setAdapter(spinnerAdapter);

            }
            @Override
            public void onFailure(Call<List<Post>> call,  Throwable t){
                Log.d("TAG", "onFailure: " + t.getMessage());

            }
        });

        call2.enqueue(new Callback<List<Post>>(){
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response){
                List<Post> posts = response.body();

                //Hospital Spinner
                List<String> spinnerItems2 = new ArrayList<>();
                for(Post post : posts){
                    spinnerItems2.add(post.getHospitalName());
                }
                ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<>(User_Interface.this,
                        android.R.layout.simple_spinner_item, spinnerItems2);
                spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                hospitals_spinner.setAdapter(spinnerAdapter2);

            }
            @Override
            public void onFailure(Call<List<Post>> call2,  Throwable t){
                Log.d("TAG", "onFailure: " + t.getMessage());

            }
        });
    }




//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
////        String selectedOption = adapterView.getItemAtPosition(i).toString();
//        String selectedItem = data[i];
//        if (selectedItem.equals("LogOut")) {
//            // Perform logout action here
//            Toast.makeText(getApplicationContext(), "Logging out...", Toast.LENGTH_SHORT).show();
//            // You can also navigate to a logout screen or clear the user's session data here
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
    public void openmain() {
    Intent intent = new Intent(this, User_Interface.class);
    startActivity(intent);
}
    public void opencalendar() {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }
}