package com.example.smartgp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DataAddEform extends AppCompatActivity {
    EditText FormID,PatName,Symptoms,AdminUsername,Declaration;
    Button AddEForm,Back;
    Eform eform;
    Patient patient;
    FirebaseDatabase root;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add_eform);
        FormID = (EditText) findViewById(R.id.FormID);
        PatName = (EditText)findViewById(R.id.PatientNameEForm);
        Symptoms = (EditText)findViewById(R.id.Symptoms);
        AdminUsername = (EditText)findViewById(R.id.AdminUsername);
        Declaration = (EditText)findViewById(R.id.Declaration);
        AddEForm =(Button)findViewById(R.id.SubmitEForm);
        patient = new Patient();
        eform = new Eform();
        root = FirebaseDatabase.getInstance();
        Back = (Button) findViewById(R.id.EFormBack);
        reference = root.getReference("Eform");
        String PatientName = PatName.getText().toString().trim();
        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference();

        Query query = reference1.child("Patient").orderByChild("patientName").equalTo(PatientName);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot issue : dataSnapshot.getChildren()) {
                        patient = dataSnapshot.getValue(Patient.class);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        AddEForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = patient.getPatientID();
                eform.setPatientID(id);
                eform.setAdminUsername(AdminUsername.getText().toString().trim());
                eform.setDeclaration(Declaration.getText().toString().trim());
                eform.setSymptoms(Symptoms.getText().toString().trim());
                eform.seteFormID(Integer.parseInt(FormID.getText().toString().toLowerCase()));
                reference.push().setValue(eform);
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