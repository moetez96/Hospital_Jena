package com.example.ws_back.entities;

public class Disease {
    public String name;
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
