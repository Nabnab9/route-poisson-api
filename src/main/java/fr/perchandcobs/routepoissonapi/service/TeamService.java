package fr.perchandcobs.routepoissonapi.service;

import fr.perchandcobs.routepoissonapi.domain.Team;
import fr.perchandcobs.routepoissonapi.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    private final PositionService positionService;

    public TeamService(TeamRepository teamRepository, PositionService positionService) {
        this.teamRepository = teamRepository;
        this.positionService = positionService;
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public Optional<Team> findByName(String name) {
        return teamRepository.findByName(name);
    }

    public List<Team> findAllTeamsWithPositions() {
        return teamRepository.findAll().stream()
                .map(p -> p.setPositions(positionService.findAllByTeamName(p.getName())))
                .collect(Collectors.toList());
    }

}
