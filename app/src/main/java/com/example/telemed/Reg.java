package com.example.telemed;

public class Reg {

    // from database?
    private String username, first_name, midname, last_name, suffix, sex, password;
    private String birth_date, mobile;


    public Reg(String username, String first_name, String midname, String last_name, String suffix,
               String sex, String password, String birth_date, String mobile) {
        this.username = username;
        this.first_name = first_name;
        this.midname = midname;
        this.last_name = last_name;
        this.suffix = suffix;
        this.sex = sex;
        this.password = password;
        this.birth_date= birth_date;
        this.mobile = mobile;

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

