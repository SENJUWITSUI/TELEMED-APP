package com.example.telemed;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class StartupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(StartupScreen.this, MainActivity.class));
            finish();
        },3000);
    }
}