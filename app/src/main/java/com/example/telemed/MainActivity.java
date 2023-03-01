package com.example.telemed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private RecyclerView rcvUser;
    private RecyclerView rcvOspital;
    private HakbangAdapter hakbangAdapter;
    private UserAdapter userAdapter;
    private OspitalAdapter ospitalAdapter;
    private Button clickme,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickme = (Button) findViewById(R.id.magpakonsulta);
        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGalleryActivity();

            }
        });
        reg = (Button) findViewById(R.id.register_btn);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openregActivity();

            }
        });

        rcvCategory = findViewById(R.id.rcv_category);
        rcvUser = findViewById(R.id.rcv_user);
        rcvOspital = findViewById(R.id.rcv_ospital);
//Hakbang
        hakbangAdapter = new HakbangAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvCategory.setLayoutManager(linearLayoutManager);
        rcvCategory.setFocusable(false);
        rcvCategory.setNestedScrollingEnabled(false);

        hakbangAdapter.setData(getListHakbang());
        rcvCategory.setAdapter(hakbangAdapter);
//Serbisyo
        userAdapter = new UserAdapter();
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager2);
        rcvUser.setFocusable(false);
        rcvUser.setNestedScrollingEnabled(false);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
//Ospital
        ospitalAdapter = new OspitalAdapter();
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        rcvOspital.setLayoutManager(linearLayoutManager3);
        rcvOspital.setFocusable(false);
        rcvOspital.setNestedScrollingEnabled(false);

        ospitalAdapter.setData(getListOspital());
        rcvOspital.setAdapter(ospitalAdapter);


    }
//Hakbang
    private List<Hakbang> getListHakbang() {
        List<Hakbang> list = new ArrayList<>();
        list.add(new Hakbang("1 Hakbang","Mag Register o mag Login","Mag rehistro para magkaroon ng account at i-login ito."));
        list.add(new Hakbang("2 Hakbang","Mag pa-iskedyul","Pumili ng iskedyul sa loob kalendaryo."));
        list.add(new Hakbang("3 Hakbang","Mag pa-konsulta","I-click ang link upang simulan ang konsulta."));
        list.add(new Hakbang("4 Hakbang","e-Reseta","I-download and reseta na binigay ng doktor."));

        return list;
    }
//Serbisyo
    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.doctor,"Konsulta sa Bata (Pediatrics)"));
        list.add(new User(R.drawable.doctor,"Konsulta sa Buntis (OB-Gyne)"));
        list.add(new User(R.drawable.doctor,"Konsulta para sa Operasyon (Surgery)"));
        list.add(new User(R.drawable.doctor,"Konsultang Medikal edad 18 pataas (Internal Medicine)"));

        return list;
    }
//Ospital
    private List<Ospital> getListOspital() {
        List<Ospital> list = new ArrayList<>();
        list.add(new Ospital(R.drawable.ospital1,"LAGUNA MEDICAL CENTER","0968-252-8415"));
        list.add(new Ospital(R.drawable.ospital2,"DR. JP RIZAL MEMORIAL DISTRICT HOSPITAL","0938-786-3615"));
        list.add(new Ospital(R.drawable.ospital3,"SAN PABLO CITY DISTRICT HOSPITAL","0919-814-1775"));

        return list;
    }


    public void openGalleryActivity () {

        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);

    }

    public void openregActivity(){

        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);

    }

}