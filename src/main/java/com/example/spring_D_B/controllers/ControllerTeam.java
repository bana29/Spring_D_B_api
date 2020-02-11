package com.example.spring_D_B.controllers;

import com.example.spring_D_B.entities.ResponseTeam;
import com.example.spring_D_B.entities.Team;
import com.example.spring_D_B.helpers.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController

public class ControllerTeam {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @RequestMapping(value = "/teams")
    public List<Team> getTeam() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-Auth-Token",Constante.API_TOKEN);
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        ResponseTeam response = restTemplate().exchange(Constante.API_URL, HttpMethod.GET, entity, ResponseTeam.class).getBody();
        List<Team> teams= response.getTeams().stream().map(
                it->{
                    return new Team(it.getId(),it.getName(),it.getTla());
                }
        ).collect(Collectors.toList());


        return teams;

    }





}
