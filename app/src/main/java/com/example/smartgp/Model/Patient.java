package com.example.smartgp.Model;

public class Patient {
    private String patientID;
    private String patientName;
    private String patientEmail;
    private String bloodType;
    private String Allergy;

    public Patient(){

    }

    public Patient(String patientID, String patientName, String patientEmail, String bloodType, String allergy) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
        this.bloodType = bloodType;
        Allergy = allergy;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergy() {
        return Allergy;
    }

    public void setAllergy(String allergy) {
        Allergy = allergy;
    }


}
