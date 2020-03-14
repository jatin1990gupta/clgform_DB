package com.example.recview;

import java.io.Serializable;

public class data implements Serializable {
    String name;
    String gender;
    String dob;
    String fname;
    String focc;
    String board10;
    String roll10;
    String per10;
    String board12;
    String roll12;
    String per12;
    String mob;
    String email;
    String address;
    String programme;
    String time;

    public data(String mname, String mgender,  String mdob, String mfname, String mfocc, String mboard10, String mroll10, String mper10,
                String mboard12, String mroll12, String mper12, String mmob, String memail, String maddress, String mprogramme, String mtime) {

        name = mname;
        gender = mgender;
        dob = mdob;
        fname = mfname;
        focc = mfocc;
        board10 = mboard10;
        roll10 = mroll10;
        per10 = mper10;
        board12 = mboard12;
        roll12 = mroll12;
        per12 = mper12;
        mob = mmob;
        email = memail;
        address = maddress;
        programme = mprogramme;
        time = mtime;

    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getFname() {
        return fname;
    }

    public String getFocc() {
        return focc;
    }

    public String getBoard10() {
        return board10;
    }

    public String getRoll10() {
        return roll10;
    }

    public String getPer10() {
        return per10;
    }

    public String getBoard12() {
        return board12;
    }

    public String getRoll12() {
        return roll12;
    }

    public String getPer12() {
        return per12;
    }

    public String getMob() { return mob; }

    public String getEmail() { return email; }

    public String getAddress() {
        return address;
    }

    public String getProgramme() {
        return programme;
    }

    public String getTime() { return time; }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFocc(String focc) {
        this.focc = focc;
    }

    public void setBoard10(String board10) {
        this.board10 = board10;
    }

    public void setRoll10(String roll10) {
        this.roll10 = roll10;
    }

    public void setPer10(String per10) {
        this.per10 = per10;
    }

    public void setBoard12(String board12) {
        this.board12 = board12;
    }

    public void setRoll12(String roll12) {
        this.roll12 = roll12;
    }

    public void setPer12(String per12) {
        this.per12 = per12;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setTime(String time) { this.time = time; }
}
