package com.example.telemed;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.FileReader;
import java.util.Calendar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Registration extends AppCompatActivity {

    private EditText bday;

    RadioButton male, female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //show , hide password
        ImageView imageViewshowHidepass = findViewById(R.id.imgshow);
        imageViewshowHidepass.setImageResource(R.drawable.off);
        imageViewshowHidepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText pass = findViewById(R.id.password);
                if (pass.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    //if pass is visible
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //cnange icon
                    imageViewshowHidepass.setImageResource(R.drawable.off);
                } else {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewshowHidepass.setImageResource(R.drawable.on);
                }
            }
        });

        //show , hide password on confirm
        ImageView imageViewshowHidepass1 = findViewById(R.id.imghide);
        imageViewshowHidepass1.setImageResource(R.drawable.off);
        imageViewshowHidepass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText cpass = findViewById(R.id.confirmpassw);
                if (cpass.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    //if pass is visible
                    cpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //cnange icon
                    imageViewshowHidepass1.setImageResource(R.drawable.off);
                } else {
                    cpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewshowHidepass1.setImageResource(R.drawable.on);
                }
            }
        });

        TextView textv;

        ScrollView coor;
        FloatingActionButton floatingactionbtn;

        EditText fname, mname, lname, sname, bday, contactnum,username, password, confirmpassw;

        // radiobutton
        // male = (RadioButton) findViewById(R.id.male);
        // female = (RadioButton) findViewById(R.id.female);



        fname = findViewById(R.id.fname);
        mname = findViewById(R.id.mname);
        lname = findViewById(R.id.lname);
        sname = findViewById(R.id.sname);
        bday = findViewById(R.id.bday);
        contactnum = findViewById(R.id.contactnum);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmpassw = findViewById(R.id.confirmpassw);
        //  maleradioButton = findViewById(R.id.maleradioButton);
        // fmaleradioButtonn = findViewById(R.id.fmaleradioButton);

        bday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        Registration.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                bday.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }

        });


        textv=(TextView)findViewById(R.id.yes);
        textv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, haveacc.class));
                //Intent intent = new Intent(MainActivity.this,haveacc.class);
                Toast.makeText(getApplicationContext(), "You Click Me :)) ", Toast.LENGTH_SHORT).show();
            }
        });

        coor=findViewById(R.id.scroll);
        floatingactionbtn = findViewById(R.id.floatingbtn);

        floatingactionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coor.fullScroll(coor.FOCUS_UP);
                floatingactionbtn.show();



            }
        });

        Button submitbtn = (Button) findViewById(R.id.submitbtn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = fname.getText().toString();
                String middle = mname.getText().toString();
                String last = lname.getText().toString();
                String suf = sname.getText().toString();
                String berday = bday.getText().toString();
                String cpno = contactnum.getText().toString();
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                String confirmpass = confirmpassw.getText().toString();


                boolean check = validateinfo(name, middle, last, suf, berday, cpno, uname, pass, confirmpass);
                if (check) {
                    Toast.makeText(getApplicationContext(), "You are now Registered! ", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean validateinfo(String name, String middle, String last, String suf, String berday, String cpno, String uname, String pass, String confirmpass) {


                if (name.length() == 0) {
                    fname.requestFocus();
                    fname.setError("Field cannot be Empty");
                    return false;
                }  else if (!name.matches("[a-zA-Z]+")) {
                    fname.requestFocus();
                    fname.setError("Enter only Alphabetical Character");
                    return false;
                }  else if (last.length() == 0) {
                    lname.requestFocus();
                    lname.setError("Field cannot be Empty");
                    return false;
                } else if (!last.matches("[a-zA-Z]+")) {
                    lname.requestFocus();
                    lname.setError("Enter only Alphabetical Character");
                    return false;

                }  else if (berday.length() == 0) {
                    bday.requestFocus();
                    bday.setError("Field cannot be Empty");
                    return false;

                } else if (cpno.length() == 0) {
                    contactnum.requestFocus();
                    contactnum.setError("Field cannot be Empty");
                    return false;
                } else if (!cpno.matches("^(09|\\+639)\\d{9}$")) {
                    contactnum.requestFocus();
                    contactnum.setError("Invalid Pattern");
                    return false;

                } else if (uname.length() == 0) {
                    username.requestFocus();
                    username.setError("Field cannot be Empty");
                    return false;
                } else if (!uname.matches("[a-zA-Z]+")) {
                    username.requestFocus();
                    username.setError("Enter only Alphabetical Character");
                    return false;
                } else if (pass.length() <= 7) {
                    password.requestFocus();
                    password.setError("Minimum of 8 Character Required");
                    return false;
                } else if (!pass.equals(confirmpass)) {
                    confirmpassw.setError("Password not match");
                    return false;

                } else {
                    return true;
                }

            }
        });

    }
}
