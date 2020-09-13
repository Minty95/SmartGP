package com.example.smartgp.Model;

public class Eform {
    private String eFormID;
    private String symptoms;
    private String patientID;
    private String adminUsername;
    private String declaration;
    public Eform(){}

    public Eform(String eFormID, String symptoms, String patientID, String adminUsername, String declaration) {
        this.eFormID = eFormID;
        this.symptoms = symptoms;
        this.patientID = patientID;
        this.adminUsername = adminUsername;
        this.declaration = declaration;
    }

    public String geteFormID() {
        return eFormID;
    }

    public void seteFormID(String eFormID) {
        this.eFormID = eFormID;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
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

