package com.example.spring_D_B.controllers;

import com.example.spring_D_B.entities.ResponseTeam;
import com.example.spring_D_B.entities.Team;
import com.example.spring_D_B.helpers.Constante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.logging.Logger.getLogger;


@RestController
public class ControllerTeam {
    Logger logger = LoggerFactory.getLogger(ControllerTeam.class);



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
        ResponseEntity<String> statut= restTemplate().exchange(Constante.API_URL, HttpMethod.GET, entity, String.class);
        ResponseTeam response = restTemplate().exchange(Constante.API_URL, HttpMethod.GET, entity, ResponseTeam.class).getBody();
        List<Team> teams= response.getTeams().stream().map(
                it->{
                    return new Team(it.getId(),it.getName(),it.getTla(),it.getFounded());
                }
        ).collect(Collectors.toList());
        logger.info("teams: " +teams);
        logger.info("statut: " +statut.getStatusCodeValue());
        logger.info("number team: " +teams.size());
        logger.info("response api: " +response);

        return teams;

    }
    @RequestMapping(value = "/team")
    @ResponseBody
    public List<Team> getTeamSortedByDate(@RequestParam String sorted) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-Auth-Token",Constante.API_TOKEN);
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        ResponseTeam response = restTemplate().exchange(Constante.API_URL, HttpMethod.GET, entity, ResponseTeam.class).getBody();
        List<Team> teams= response.getTeams().stream().map(
                it->{
                    return new Team(it.getId(),it.getName(),it.getTla(),it.getFounded());
                }
        ).collect(Collectors.toList());

      if (sorted.equals("date")){
           teams.sort(Comparator.comparing(Team::getFounded));
          return teams;
      }else if (sorted.equals("name")){
            teams.sort(Comparator.comparing(Team::getName));
          return teams;
      }
        return teams;

    }





}
