package fr.perchandcobs.routepoissonapi.controller;

import fr.perchandcobs.routepoissonapi.domain.Team;
import fr.perchandcobs.routepoissonapi.dto.RTeam;
import fr.perchandcobs.routepoissonapi.exception.NotFoundException;
import fr.perchandcobs.routepoissonapi.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<Team>> findAllTeamsWithPositions() {
        return ResponseEntity.ok(teamService.findAllTeamsWithPositions());
    }

    @GetMapping("/teams/{name}")
    public ResponseEntity<Team> findTeamByName(@PathVariable String name) {
        return teamService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> addTeam(@RequestBody RTeam team) {
        Team t = new Team()
                .setName(team.getName())
                .setPositions(new ArrayList<>())
                .setLetter(team.getLetter())
                .setMembers(team.getMembers());
        return ResponseEntity.ok(teamService.addTeam(t));
    }

    @DeleteMapping("/teams/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String teamId) {
        teamService.deleteTeam(teamId);
        return ResponseEntity.noContent().build();
    }


}
