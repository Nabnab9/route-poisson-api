package fr.perchandcobs.routepoissonapi.repository;

import fr.perchandcobs.routepoissonapi.domain.Position;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends MongoRepository<Position, String> {

    List<Position> findAllByTeam_Name(String teamName);

}
