package com.example.ws_back.entities;

public class Patient {
    public String name;
    public String age;
    public String cin;
    public String phone;
    public String type;
    public String suffersFrom;
    public String locatedIn;
    public String attendedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuffersFrom() {
        return suffersFrom;
    }

    public void setSuffersFrom(String suffersFrom) {
        this.suffersFrom = suffersFrom;
    }

    public String getLocatedIn() {
        return locatedIn;
    }

    public void setLocatedIn(String locatedIn) {
        this.locatedIn = locatedIn;
    }

    public String getAttendedBy() {
        return attendedBy;
    }

    public void setAttendedBy(String attendedBy) {
        this.attendedBy = attendedBy;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", cin='" + cin + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", suffersFrom='" + suffersFrom + '\'' +
                ", locatedIn='" + locatedIn + '\'' +
                ", attendedBy='" + attendedBy + '\'' +
                '}';
    }
}
