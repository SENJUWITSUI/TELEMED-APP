package com.example.telemed;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration extends AppCompatActivity {
    String url= "http://10.20.107.159:8080/api/";
    //        private EditText firstnme, mddlenme,lstnme,suffnme,b_day,cntctnmbr,usrnme,pswrd,cnfrmpswrn;
//        private Dialog myDialog;
    private EditText username, first_name, middle_name, last_name, suffix, password, birth_date, mobile;
    private Button submitbtn;
    private ProgressBar Loading;
    private RadioGroup sex;
    private TextView responsetv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        first_name = findViewById(R.id.fname);
        middle_name = findViewById(R.id.mname);
        last_name = findViewById(R.id.lname);
        suffix = findViewById(R.id.sname);
        birth_date = findViewById(R.id.bday);
        password = findViewById(R.id.password);
        mobile = findViewById(R.id.contactnum);
        username = findViewById(R.id.username);
        sex = findViewById(R.id.rdgrp);
        submitbtn = findViewById(R.id.submitbtn);
        Loading = findViewById(R.id.LoadingPB);


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (first_name.getText().toString().isEmpty() && middle_name.getText().toString().isEmpty()
                        && last_name.getText().toString().isEmpty() && suffix.getText().toString().isEmpty()
                        && birth_date.getText().toString().isEmpty() && password.getText().toString().isEmpty()
                        && mobile.getText().toString().isEmpty() && username.getText().toString().isEmpty()) {
                    Toast.makeText(Registration.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (sex.getCheckedRadioButtonId() == '1') {
                    String sex = "Female";
                    postData(first_name.getText().toString().trim(), middle_name.getText().toString().trim()
                            , last_name.getText().toString().trim(), suffix.getText().toString().trim(),
                            birth_date.getText().toString().trim(), password.getText().toString().trim(),
                            mobile.getText().toString().trim(), username.getText().toString().trim(), sex);
                } else {
                    String sex = "Male";
                    postData(first_name.getText().toString().trim(), middle_name.getText().toString().trim()
                            , last_name.getText().toString().trim(), suffix.getText().toString().trim(),
                            birth_date.getText().toString().trim(), password.getText().toString().trim(),
                            mobile.getText().toString().trim(), username.getText().toString().trim(), sex);
                }
            }
        });

    }

    private void postData(String fname, String mname,String lname, String suff, String bday, String mobile,
                          String password, String username, String sex){

        // below line is for displaying our progress bar.
        Loading.setVisibility(View.VISIBLE);

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        // passing data from our text fields to our modal class.
//        Reg modal = new Reg(first_name, middle_name,last_name, suffix, birth_date, mobile,password);

        // calling a method to create a post and passing our modal class.

        Call<Reg> call = retrofitAPI.createReg(fname, mname,lname,suff,bday,mobile,password,username,sex);

        call.enqueue(new Callback<Reg>() {
            @Override
            public void onResponse(Call<Reg> call, Response<Reg> response) {
                if (response.isSuccessful()) {
                    // this method is called when we get response from our api.
                    Toast.makeText(Registration.this, "Data added to API", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registration.this, Login.class));
                    finish();

                    // below line is for hiding our progress bar.
                    Loading.setVisibility(View.GONE);
                    // on below line we are setting empty textfi
                    // to our both edit text.
                    first_name.setText("");
                    middle_name.setText("");
                    last_name.setText("");
                    suffix.setText("");
                    birth_date.setText("");
                    sex.equals("");
                    password.equals("");
                    mobile.equals("");
                    username.equals("");

                    // we are getting response from our body
                    // and passing it to our modal class.
                    Reg responseFromAPI = response.body();

                }
                else {
                    Toast.makeText(Registration.this, "Data not added to API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Reg> call, Throwable t) {
                Loading.setVisibility(View.GONE);
                t.printStackTrace();
                responsetv.setText("Error found is : " + t.getMessage());
            }
        });


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


//
        TextView textv;

        ScrollView coor;
        FloatingActionButton floatingactionbtn;
//
//            EditText fname, mname, lname, sname, bday, contactnum,username, password, confirmpassw;
        EditText biday;
//        // radiobutton
//        // male = (RadioButton) findViewById(R.id.male);
//        // female = (RadioButton) findViewById(R.id.female);

        biday = findViewById(R.id.bday);
//            contactnum = findViewById(R.id.contactnum);
//            username = findViewById(R.id.username);
//            password = findViewById(R.id.password);
//            confirmpassw = findViewById(R.id.confirmpassw);
        //  maleradioButton = findViewById(R.id.maleradioButton);
        // fmaleradioButtonn = findViewById(R.id.fmaleradioButton);

        biday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

//                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        Registration.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                biday.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

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


//            textv=(TextView)findViewById(R.id.yes);
//            textv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    startActivity(new Intent(Registration.this, Login.class));
//                    //  Toast.makeText(getApplicationContext(), "You Click Me :)) ", Toast.LENGTH_SHORT).show();
//                }
//            });

        coor=findViewById(R.id.scroll);
        floatingactionbtn = findViewById(R.id.floatingbtn);

        floatingactionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coor.fullScroll(coor.FOCUS_UP);
                floatingactionbtn.show();



            }
        });
//
//            Button submitbtn = (Button) findViewById(R.id.submitbtn);
//            submitbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String name = fname.getText().toString();
//                    String middle = mname.getText().toString();
//                    String last = lname.getText().toString();
//                    String suf = sname.getText().toString();
//                    String berday = bday.getText().toString();
//                    String cpno = contactnum.getText().toString();
//                    String uname = username.getText().toString();
//                    String pass = password.getText().toString();
//                    String confirmpass = confirmpassw.getText().toString();
//
//
//                    boolean check = validateinfo(name, middle, last, suf, berday, cpno, uname, pass, confirmpass);
//                    if (check) {
//                        startActivity(new Intent(MainActivity.this, MainActivity.class));
//
//                        Toast.makeText(getApplicationContext(), "You are now Registered! ", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                private boolean validateinfo(String name, String middle, String last, String suf, String berday, String cpno, String uname, String pass, String confirmpass) {
//
//
//                    if (name.length() == 0) {
//                        fname.requestFocus();
//                        fname.setError("Field cannot be Empty");
//                        return false;
//                    }  else if (!name.matches("[a-zA-Z]+")) {
//                        fname.requestFocus();
//                        fname.setError("Enter only Alphabetical Character");
//                        return false;
//                    }  else if (last.length() == 0) {
//                        lname.requestFocus();
//                        lname.setError("Field cannot be Empty");
//                        return false;
//                    } else if (!last.matches("[a-zA-Z]+")) {
//                        lname.requestFocus();
//                        lname.setError("Enter only Alphabetical Character");
//                        return false;
//
//                    }  else if (berday.length() == 0) {
//                        bday.requestFocus();
//                        bday.setError("Field cannot be Empty");
//                        return false;
//
//                    } else if (cpno.length() == 0) {
//                        contactnum.requestFocus();
//                        contactnum.setError("Field cannot be Empty");
//                        return false;
//                    } else if (!cpno.matches("^(09|\\+639)\\d{9}$")) {
//                        contactnum.requestFocus();
//                        contactnum.setError("Invalid Pattern");
//                        return false;
//
//                    } else if (uname.length() == 0) {
//                        username.requestFocus();
//                        username.setError("Field cannot be Empty");
//                        return false;
//                    } else if (!uname.matches("[a-zA-Z]+")) {
//                        username.requestFocus();
//                        username.setError("Enter only Alphabetical Character");
//                        return false;
//                    } else if (pass.length() <= 7) {
//                        password.requestFocus();
//                        password.setError("Minimum of 8 Character Required");
//                        return false;
//                    } else if (!pass.equals(confirmpass)) {
//                        confirmpassw.setError("Password not match");
//                        return false;
//
//                    } else {
//                        return true;
//                    }
//                }
//            });

//            myDialog = new Dialog(this);
//            Button popupBTN = (Button) findViewById(R.id.popupBTN);
//            popupBTN.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    myDialog.setContentView(R.layout.activity_dialog);
//                    Button myDialogButton = myDialog.findViewById(R.id.register);
//                    Button myDialog1Button = myDialog.findViewById(R.id.loginbtn);
//
//                    myDialogButton.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent intent = new Intent(Registration.this, Registration.class);
//                            startActivity(intent);
//
//                        }
//                    });
//
//                    myDialog1Button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent intent = new Intent(Registration.this, Login.class);
//                            startActivity(intent);
//
//
//                        }
//                    });
//
//
//                    myDialog.show();
//                }
//            });
    }

}
