package com.example.smartgp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataAddPatient extends AppCompatActivity {
    EditText PatID,PatName,PatEmail,PatBloodType,PatAllergy;
    Button AddPatient,Back;
    Patient patient;
    FirebaseDatabase root;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add_patient);
        PatID = (EditText) findViewById(R.id.PatientID);
        PatName = (EditText)findViewById(R.id.PatientName);
        PatAllergy = (EditText)findViewById(R.id.PatientAllergy);
        PatBloodType = (EditText)findViewById(R.id.PatientBloodType);
        PatEmail = (EditText)findViewById(R.id.PatientEmail);
        AddPatient =(Button)findViewById(R.id.SubmitP);
        patient = new Patient();
        root = FirebaseDatabase.getInstance();
        Back = (Button) findViewById(R.id.PatientBack);
        reference = root.getReference("Patient");
        AddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= Integer.parseInt(PatID.getText().toString().trim());
                patient.setPatientID(id);
                patient.setPatientName(PatName.getText().toString().trim());
                patient.setAllergy(PatAllergy.getText().toString().trim());
                patient.setBloodType(PatBloodType.getText().toString().trim());
                patient.setPatientEmail(PatEmail.getText().toString().trim());
                reference.push().setValue(patient);
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