package com.example.telemed;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    Dialog myDialog;
    TextView create;
    private static String API_BASE_URL = "http://10.20.109.200:8080/api/";
    EditText username, passwords;
    Button btnLogin;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        passwords = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(passwords.getText().toString())){
                    Toast.makeText(Login.this,"Username / Password Required", Toast.LENGTH_LONG).show();
                }
                // calling a method to post the data and passing our name and job.
                login();
            }
        });


        myDialog = new Dialog(this);
        Button popupBTN = (Button) findViewById(R.id.popupBTN);
        popupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.activity_dialog);
                Button myDialogButton = myDialog.findViewById(R.id.register);
                Button myDialog1Button = myDialog.findViewById(R.id.loginbtn);

                myDialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, Registration.class);
                        startActivity(intent);

                    }
                });

                myDialog1Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, Login.class);
                        startActivity(intent);

                    }
                });


                myDialog.show();
            }
        });

        create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
                finish();

            }
        });

    }
    private Retrofit iniRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)  //Change server URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    private void login() {
        String email = username.getText().toString().trim();
        String password = passwords.getText().toString().trim();
        InterfaceAPI interfaceAPI = iniRetrofit().create(InterfaceAPI.class);

//        progressBar.setVisibility(View.VISIBLE); // Show progress bar

        Call<LoginResponse> call = interfaceAPI.checklogin(email, password);
        call.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
//                    progressBar.setVisibility(View.GONE);

                    Toast.makeText(Login.this,"Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(Login.this,User_Interface.class));
                            finish();
                        }
                    },700);

                }else{
                    Toast.makeText(Login.this,"Invalid Credential. Please try again", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                progressBar.setVisibility(View.GONE);
                t.printStackTrace();

                //Response failed
                Log.e("TAG", "Response: " + t.getMessage());            }
        });
    }
}


