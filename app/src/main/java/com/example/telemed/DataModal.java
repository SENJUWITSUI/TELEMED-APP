package com.example.telemed;

public class DataModal {

    // string variables for our name and job
    private String fname;
    private String mname;
    private String lname;
    private String sname;
    private String bday;
    private String contactnum;
    private String male;
    private String female;
    private String username;
    private String password;
    private String confirmpassw;

    public DataModal(String fname, String mname, String lname, String sname, String bday, String contactnum, String male, String female, String username, String password, String confirmpassw) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.sname = sname;
        this.bday = bday;
        this.contactnum = contactnum;
        this.male = male;
        this.female = female;
        this.username = username;
        this.password = password;
        this.confirmpassw = confirmpassw;

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getContactnum() {
        return contactnum;
    }

    public void setContactnum(String contactnum) {
        this.contactnum = contactnum;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassw() {
        return confirmpassw;
    }

    public void setConfirmpassw(String confirmpassw) {

        this.confirmpassw = confirmpassw;
    }


}



