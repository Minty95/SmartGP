package com.example.smartgp.CreateEntities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartgp.Model.Appointment;
import com.example.smartgp.Model.Patient;
import com.example.smartgp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;

public class DataAddAppointment extends AppCompatActivity {
    private static final String TAG = "DataAddAppointment";
    EditText ApptID,ApptStatus,ApptQueueNo,ApptDateTime,ApptPatientName;
    Button AddAppt,Back;
    Patient patient; // this is not needed as user uses google email to log in, so their details are included
    Appointment appt;
    FirebaseDatabase root;
    DatabaseReference reference;
    private String patientID; // uses Firebase Auth and firebaseUser

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
         // here is where  you do all the userAuth stuff via firebaseAuth thingy
        //patientID = (the Firebaseuser).getUid();
        /* the query is not needed as user log in through gmail. so their ID will be captured*/
        /*Query query = reference1.child("Patient").orderByChild("patientName").equalTo(patientName);
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
        });*/
        AddAppt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
                String Date = ApptDateTime.getText().toString();
                String id= patient.getPatientID();
                appt.setPatientID(id);
                try {
                    appt.setDatetime(simpleDateFormat.parse(Date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //apptID is generated key will be use to do counter check
                //appt.setApptID(Integer.parseInt(ApptID.getText().toString().trim()));
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

