package fr.perchandcobs.routepoissonapi.controller;

import fr.perchandcobs.routepoissonapi.domain.Position;
import fr.perchandcobs.routepoissonapi.domain.Team;
import fr.perchandcobs.routepoissonapi.exception.NotFoundException;
import fr.perchandcobs.routepoissonapi.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TeamController {

    private final TeamService teamService;

    Logger logger = LoggerFactory.getLogger(TeamController.class);

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<Team> findAllTeamsWithPositions( ) {
       return teamService.findAllTeamsWithPositions();
    }

    @GetMapping("/teams/{name}")
    public Team findTeamByName(@PathVariable String name){
        return teamService.findByName(name).orElseThrow(NotFoundException::new);
    }

    @PostMapping("/teams")
    public Team addTeam() {
        return teamService.addTeam(new Team().setName("C'est mieux ?").setBattery(54)).setPositions(Collections.singletonList(new Position()));
    }




}
