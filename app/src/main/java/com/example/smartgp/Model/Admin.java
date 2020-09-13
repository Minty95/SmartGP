package com.example.smartgp.Model;

public class Admin {
    private String adminName;
    private String adminUsername;
    private String adminPw;
    private String clinicID;
    public Admin(){}

    public Admin(String adminName, String adminUsername, String adminPw, String clinicID) {
        this.adminName = adminName;
        this.adminUsername = adminUsername;
        this.adminPw = adminPw;
        this.clinicID = clinicID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {
        this.adminPw = adminPw;
    }

    public String getClinicID() {
        return clinicID;
    }

    public void setClinicID(String clinicID) {
        this.clinicID = clinicID;
    }
}
