package com.example.spring_D_B.entities;

import java.util.ArrayList;

public class ResponseTeam {
    int id;
    String name;
    String tla;
    ArrayList<ResponseTeam> teams;
    int founded ;

    public ResponseTeam(int id, String name, String tla,int founded) {
        this.id = id;
        this.name = name;
        this.tla = tla;
        this.founded = founded;
    }

    public ResponseTeam() {
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

    public ArrayList<ResponseTeam> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<ResponseTeam> teams) {
        this.teams = teams;
    }
    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }
}
