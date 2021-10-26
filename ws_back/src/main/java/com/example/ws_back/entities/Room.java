package com.example.ws_back.entities;

public class Room {
    public String type;
    public String room_number;
    public String room_name;
    public String contains;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

    @Override
    public String toString() {
        return "Room{" +
                ", type='" + type + '\'' +
                ", room_number='" + room_number + '\'' +
                ", room_name='" + room_name + '\'' +
                ", contains='" + contains + '\'' +
                '}';
    }
}
