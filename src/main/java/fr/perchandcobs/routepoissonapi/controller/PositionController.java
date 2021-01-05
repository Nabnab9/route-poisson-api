package fr.perchandcobs.routepoissonapi.controller;

import fr.perchandcobs.routepoissonapi.domain.Position;
import fr.perchandcobs.routepoissonapi.domain.Team;
import fr.perchandcobs.routepoissonapi.service.PositionService;
import fr.perchandcobs.routepoissonapi.service.TeamService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PositionController {

    private final PositionService positionService;
    private final TeamService teamService;

    public PositionController(PositionService positionService, TeamService teamService) {
        this.positionService = positionService;
        this.teamService = teamService;
    }

    @PostMapping("/positions")
    public Position addPosition(
            @RequestParam float latitude,
            @RequestParam float longitude,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
            @RequestParam float speed,
            @RequestParam String team,
            @RequestParam String battery,
            @RequestParam String serial,
            @RequestParam String androidId,
            @RequestParam float altitude,
            @RequestParam float precision
            ) {

        float batteryFloat = Float.parseFloat(battery.substring(0, 4));

        Team savedTeam = teamService.findByName(team)
                .map(p -> p.setBattery(batteryFloat))
                .map(teamService::addTeam)
                .orElseGet(() -> teamService.addTeam(new Team().setBattery(batteryFloat).setName(team)));

        return positionService.addPosition(
                new Position()
                .setAltitude(altitude)
                .setAndroidId(androidId)
                .setBattery(batteryFloat)
                .setDateTime(dateTime)
                .setLatitude(latitude)
                .setLongitude(longitude)
                .setSpeed(speed)
                .setTeam(savedTeam)
                .setSerial(serial)
                .setPrecision(precision)
        );
    }

    @GetMapping("/positions")
    public List<Position> findAllPositions( ) {
        return positionService.findAll();
    }

}
