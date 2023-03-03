package com.example.telemed;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {
    private Button button;
    TextView txt;
    Dialog dialog;

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