package com.example.smartgp.Model;

public class Chat {
    private String chatID;
    private String patientID;
    private String clinicID;
    private String formID;
    private String adminUsername;
    private String chat;

    public Chat() {
    }

    public Chat(String chatID, String patientID, String clinicID, String formID, String adminUsername, String chat) {
        this.chatID = chatID;
        this.patientID = patientID;
        this.clinicID = clinicID;
        this.formID = formID;
        this.adminUsername = adminUsername;
        this.chat = chat;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getClinicID() {
        return clinicID;
    }

    public void setClinicID(String clinicID) {
        this.clinicID = clinicID;
    }

    public String getFormID() {
        return formID;
    }

    public void setFormID(String formID) {
        this.formID = formID;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }
}
