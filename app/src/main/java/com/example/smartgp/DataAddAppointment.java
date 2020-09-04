package com.example.smartgp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;

public class DataAddAppointment extends AppCompatActivity {
    EditText ApptID,ApptStatus,ApptQueueNo,ApptDateTime,ApptPatientName;
    Button AddAppt,Back;
    Patient patient;
    Appointment appt;
    FirebaseDatabase root;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add_appointment);
        ApptID = (EditText) findViewById(R.id.ApptId);
        ApptStatus = (EditText)findViewById(R.id.Status);
        ApptQueueNo = (EditText)findViewById(R.id.QueueNo);
        ApptDateTime = (EditText)findViewById(R.id.DateTime);
        ApptPatientName =(EditText) findViewById(R.id.PatientNameAppt);
        AddAppt = (Button)findViewById(R.id.SubmitAppt);
        appt = new Appointment();
        patient = new Patient();
        root = FirebaseDatabase.getInstance();
        Back = (Button) findViewById(R.id.ApptBack);
        reference = root.getReference("Appointment");
        String patientName = ApptPatientName.getText().toString().trim();
        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference();
        Query query = reference1.child("Patient").orderByChild("patientName").equalTo(patientName);
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
        AddAppt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
                String Date = ApptDateTime.getText().toString();
                int id= patient.getPatientID();
                appt.setPatientID(id);
                try {
                    appt.setDatetime(simpleDateFormat.parse(Date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                appt.setApptID(Integer.parseInt(ApptID.getText().toString().trim()));
                appt.setQueueNo(Integer.parseInt(ApptQueueNo.getText().toString().trim()));
                appt.setStatus(ApptStatus.getText().toString().trim());
                reference.push().setValue(appt);
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBack();
            }
        });

    }
    public void openBack(){
        Intent intent = new Intent(this,DataInsert1.class);
        startActivity(intent);
    }
    }

