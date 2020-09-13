package com.example.smartgp.CreateEntities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartgp.Model.Admin;
import com.example.smartgp.Model.Clinic;
import com.example.smartgp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DataAddAdmin extends AppCompatActivity {
    EditText AdminName,AdminUsername,ClinicName,AdminPW;
    Button AddAdmin,Back;
    Clinic clinic;
    Admin admin;
    FirebaseDatabase root;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add_admin);
        AdminName = (EditText) findViewById(R.id.AdminName);
        ClinicName = (EditText)findViewById(R.id.ClinicName);
        AdminUsername = (EditText)findViewById(R.id.AdminUsername);
        AdminPW = (EditText)findViewById(R.id.AdminPW);
        AddAdmin =(Button)findViewById(R.id.SubmitAdmin);
        clinic = new Clinic();
        admin = new Admin();
        root = FirebaseDatabase.getInstance();
        Back = (Button) findViewById(R.id.AdminBack);
        reference = root.getReference("Admin");
        String clinicName = ClinicName.getText().toString().trim();
        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference();
        Query query = reference1.child("Clinic").orderByChild("clinicName").equalTo(clinicName);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot issue : dataSnapshot.getChildren()) {
                        clinic = dataSnapshot.getValue(Clinic.class);

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        AddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id= clinic.getClinicID();
                admin.setAdminName(AdminName.getText().toString().trim());
                admin.setAdminPw(AdminPW.getText().toString().trim());
                admin.setAdminUsername(AdminUsername.getText().toString().trim());
                admin.setClinicID(id);
                reference.push().setValue(admin);
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