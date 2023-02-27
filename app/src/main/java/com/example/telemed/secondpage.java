package com.example.telemed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class secondpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);

        Button backbtn = (Button) findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(secondpage.this, MainActivity.class));
                //Intent intent = new Intent(MainActivity.this,sarcondpage.class);
                Toast.makeText(getApplicationContext(), "Bye bye :)) ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}