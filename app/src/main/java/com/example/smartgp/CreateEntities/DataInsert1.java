package com.example.smartgp.CreateEntities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartgp.R;

public class DataInsert1 extends AppCompatActivity {
    private Button toPatientDB,toClinicDB,toEFromDB,toAdminDB,toApptDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert1);
        toPatientDB = (Button) findViewById(R.id.button2);
        toEFromDB = (Button) findViewById(R.id.button3);
        toClinicDB =(Button) findViewById(R.id.button4);
        toAdminDB = (Button) findViewById(R.id.button5);
        toApptDB = (Button) findViewById(R.id.button7);
        toApptDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddAppt();
            }
        });
        toAdminDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddAdmin();
            }
        });
        toEFromDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddEForm();
            }
        });
        toClinicDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddClinic();
            }
        });
        toPatientDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddPatient();
            }
        });
    }
    public void openAddPatient(){
        Intent intent1 = new Intent(this,DataAddPatient.class);
        startActivity(intent1);
    }
    public void openAddClinic() {
        Intent intent = new Intent(this,DataAddClinic.class);
        startActivity(intent);
    }
    public void openAddEForm(){
        Intent intent = new Intent(this,DataAddEform.class);
        startActivity(intent);
    }
    public void openAddAdmin(){
        Intent intent = new Intent(this, DataAddAdmin.class);
        startActivity(intent);
    }
    public void openAddAppt(){
        Intent intent = new Intent(this,DataAddAppointment.class);
        startActivity(intent);
    }
}