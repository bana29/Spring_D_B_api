package com.example.spring_D_B.entities;

import lombok.ToString;

import java.util.ArrayList;
@ToString
public class Team {
    int id;
    String name;
    String tla;
    int founded;

    public Team(int id, String name, String tla, int founded) {
        this.id = id;
        this.name = name;
        this.tla = tla;
        this.founded = founded;
    }

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }
}
