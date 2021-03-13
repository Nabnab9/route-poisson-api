package fr.perchandcobs.routepoissonapi.service;

import fr.perchandcobs.routepoissonapi.domain.Position;
import fr.perchandcobs.routepoissonapi.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteByTeamId(String teamId) {
        positionRepository.deleteByTeamId(teamId);
    }

    public Optional<Position> findLastPositionInSession(String sessionId) {
        return positionRepository.findFirstBySessionIdOrderByDateTimeDesc(sessionId);
    }
}
