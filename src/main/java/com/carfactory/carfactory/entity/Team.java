package com.carfactory.carfactory.entity;

public class Team {

    private String Name;
    private String Surname;
    private String Position;
    private String Portrait;

    public Team(String name, String surname, String position, String portrait) {
        Name = name;
        Surname = surname;
        Position = position;
        Portrait = portrait;
    }

    public Team() {
    }

    public String getPortrait() {
        return Portrait;
    }

    public void setPortrait(String portrait) {
        Portrait = portrait;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

}
