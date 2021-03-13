package fr.perchandcobs.routepoissonapi.controller;

import fr.perchandcobs.routepoissonapi.domain.Position;
import fr.perchandcobs.routepoissonapi.domain.Session;
import fr.perchandcobs.routepoissonapi.domain.Team;
import fr.perchandcobs.routepoissonapi.service.PositionService;
import fr.perchandcobs.routepoissonapi.service.SessionService;
import fr.perchandcobs.routepoissonapi.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PositionController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PositionService positionService;
    private final TeamService teamService;
    private final SessionService sessionService;

    public PositionController(PositionService positionService, TeamService teamService, SessionService sessionService) {
        this.positionService = positionService;
        this.teamService = teamService;
        this.sessionService = sessionService;
    }

    @PostMapping("/positions")
    public ResponseEntity<Position> addPosition(
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

        float batteryFloat = Float.parseFloat(battery.split("\\.")[0]);

        Team savedTeam = teamService.findByName(team)
                .map(p -> p.setBattery(batteryFloat))
                .map(teamService::addTeam)
                .orElseGet(() -> teamService.addTeam(new Team().setBattery(batteryFloat).setName(team)));

        Session session = sessionService.findAllByEndDateIsNull().stream()
                .findFirst()
                .orElseGet(sessionService::createSession);

        logger.info("Created position at [{} {}] for team [{}] at dateTime [{}]", latitude, longitude, savedTeam.getName(), dateTime);
        return ResponseEntity.ok(positionService.addPosition(
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
                        .setSession(session)
        ));
    }

    @GetMapping("/positions")
    public ResponseEntity<List<Position>> findAllPositions() {
        return ResponseEntity.ok(positionService.findAll());
    }

}
