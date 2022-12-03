package com.example.zavodapp;
//login,password,name

public class User {
    public String  id,fullname,jobtitle,experience,education;
    //полное имя, должность, стаж работы, высшее образование

    public User() {
    }
    public User(String id, String fullname, String jobtitle, String experience, String education) {
        this.id = id;
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        this.experience = experience;
        this.education = education;
    }
}