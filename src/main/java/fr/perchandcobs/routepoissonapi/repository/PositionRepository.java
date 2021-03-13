package fr.perchandcobs.routepoissonapi.repository;

import fr.perchandcobs.routepoissonapi.domain.Position;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends MongoRepository<Position, String> {

    List<Position> findAllByTeam_Name(String teamName);

    void deleteByTeamId(String teamId);

    Optional<Position> findFirstBySessionIdOrderByDateTimeDesc(String sessionId);
}
