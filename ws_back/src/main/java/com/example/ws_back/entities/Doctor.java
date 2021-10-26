package com.example.ws_back.entities;

public class Doctor {
    public String name;
    public String age;
    public String cin;
    public String phone;
    public String type;
    public String takingCareOf;

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

    public String getTakingCareOf() {
        return takingCareOf;
    }

    public void setTakingCareOf(String takingCareOf) {
        this.takingCareOf = takingCareOf;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", CIN='" + cin + '\'' +
                ", phone='" + phone + '\'' +
                ", Type='" + type + '\'' +
                ", takingCareOf='" + takingCareOf + '\'' +
                '}';
    }
}
