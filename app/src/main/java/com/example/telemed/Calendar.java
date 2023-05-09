package com.example.telemed;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Calendar extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static String BASE_URL = "http://10.20.107.32:8080/api/";
    private Button button;
    TextView txt;
    Dialog dialog;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        dialog = new Dialog(Calendar.this);
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
        ipasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencalendar();
            }

        });

        txt = (TextView) dialog.findViewById(R.id.exit);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        ImageView menuIcon = findViewById(R.id.imageView);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Calendar.this, menuIcon);
                popupMenu.getMenuInflater().inflate(R.menu.logoutmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.changepass:
                                // Handle option 1 click
                                return true;
                            case R.id.logout:
                                // Handle option 2 click
                                finish();
                                Toast.makeText(getApplicationContext(), "Logout Successfully", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        startActivity(new Intent(Calendar.this,Login.class));
                                    }
                                },700);
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
                finish();
            }
        });

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
                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(Calendar.this,
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
                ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<>(Calendar.this,
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

//        spinner = findViewById(R.id.spinner);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(Calendar.this, android.R.layout.simple_spinner_item, data);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        Spinner spinner = findViewById(R.id.spinner);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String selectedItem = data[position];
//                if (selectedItem.equals("LogOut")) {
//                    // Perform logout action here
//                    Toast.makeText(getApplicationContext(), "Logout Successfully", Toast.LENGTH_SHORT).show();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            startActivity(new Intent(Calendar.this,Login.class));
//                            finish();
//                        }
//                    },700);
//                    // You can also navigate to a logout screen or clear the user's session data here
//
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    private void back() {
        Intent intent = new Intent(this, User_Interface.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption = adapterView.getItemAtPosition(i).toString();

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void opencalendar() {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }

    private void openmain() {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }
}