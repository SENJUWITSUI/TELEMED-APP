package com.example.telemed;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    Dialog myDialog;
    TextView create;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        
        loginbtn=(Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, User_Interface.class));
                //  Toast.makeText(getApplicationContext(), "You Click Me :)) ", Toast.LENGTH_SHORT).show();
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
    }


