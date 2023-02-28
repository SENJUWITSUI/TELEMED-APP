package com.example.telemed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class regheader extends AppCompatActivity {

    private Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register_btn = (Button) findViewById(R.id.register_btn);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGalleryActivity();

            }
        });
    }
    public void openGalleryActivity(){

        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);

    }

}
