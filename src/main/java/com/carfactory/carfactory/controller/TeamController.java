package com.carfactory.carfactory.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfactory.carfactory.entity.Team;
import com.carfactory.carfactory.service.TeamService;

//-----------------------------------------------------
// Title: TeamController controller
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: The TeamController class is a Spring MVC controller handling requests related to team information.
// It uses the @RequestMapping annotation to map HTTP requests to specific methods.
// The @ResponseBody annotation is used to indicate that the return value of the getTeam method should be serialized directly to the body of the HTTP response in JSON format.
//----------------------------------------------------
@Controller
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/Team")
    public String team() {
        return "Team";
    }

    @RequestMapping(value = "/TeamMembers", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public List<Team> getTeam() {
        return teamService.getTeam();
    }
}
