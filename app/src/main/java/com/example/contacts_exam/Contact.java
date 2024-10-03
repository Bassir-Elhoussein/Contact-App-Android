package com.example.contacts_exam;

public class Contact {
    int codecontact;
    String firstname;
    String secondname;
    String number;

    public Contact(String firstname, String secondname, String number) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.number = number;
    }

    public Contact() {

    }

    public Contact(int codecontact, String firstname, String secondname, String number) {
        this.codecontact = codecontact;
        this.firstname = firstname;
        this.secondname = secondname;
        this.number = number;
    }

    public int getCodecontact() {
        return codecontact;
    }

    public void setCodecontact(int codecontact) {
        this.codecontact = codecontact;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}