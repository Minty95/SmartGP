package com.example.smartgp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataAddClinic extends AppCompatActivity {
    EditText ClinicID,ClinicName,ClinicAddress,ClinicDescription,ClinicHours;
    Button AddClinic,Back;
    Clinic clinic;
    FirebaseDatabase root;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add_clinic);
        ClinicID = (EditText) findViewById(R.id.ClinicID);
        ClinicName = (EditText)findViewById(R.id.ClinicName);
        ClinicAddress = (EditText)findViewById(R.id.ClinicAddress);
        ClinicDescription = (EditText)findViewById(R.id.ClinicDescription);
        ClinicHours = (EditText)findViewById(R.id.OperatingHour);
        AddClinic =(Button)findViewById(R.id.SubmitClinic);
        clinic = new Clinic();
        root = FirebaseDatabase.getInstance();
        Back = (Button) findViewById(R.id.ClinicBack);
        reference = root.getReference("Clinic");
        AddClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= Integer.parseInt(ClinicID.getText().toString().trim());
                clinic.setClinicName(ClinicName.getText().toString().trim());
                clinic.setClinicId(id);
                clinic.setClinicDescription(ClinicDescription.getText().toString().trim());
                clinic.setOpeningHour(ClinicHours.getText().toString().trim());
                clinic.setAddress(ClinicAddress.getText().toString().trim());
                reference.push().setValue(clinic);
            }
        });
        Back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openBack();
            }
        });
    }
    public void openBack(){
        Intent intentBack = new Intent(this,DataInsert1.class);
        startActivity(intentBack);
    }
}