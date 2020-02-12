package com.example.spring_D_B.entities;

import lombok.ToString;

import java.util.ArrayList;
@ToString
public class Team {
    int id;
    String name;
    String tla;

    public Team(int id, String name, String tla) {
        this.id = id;
        this.name = name;
        this.tla = tla;
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
}
