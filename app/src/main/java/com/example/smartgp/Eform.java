package com.example.smartgp;

public class Eform {
    private int eFormID;
    private String symptoms;
    private int patientID;
    private String adminUsername;
    private String declaration;
    public Eform(){}

    public int geteFormID() {
        return eFormID;
    }

    public void seteFormID(int eFormID) {
        this.eFormID = eFormID;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }
}

