package fr.perchandcobs.routepoissonapi.service;

import fr.perchandcobs.routepoissonapi.domain.Position;
import fr.perchandcobs.routepoissonapi.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }

    public List<Position> findAllByTeamName(String teamName) {
        return positionRepository.findAllByTeam_Name(teamName);
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
