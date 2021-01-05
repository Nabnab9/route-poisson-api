package fr.perchandcobs.routepoissonapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Team {

    @Id
    private String id;

    private String name;

    private float battery;

    private List<Position> positions;

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public float getBattery() {
        return battery;
    }

    public Team setBattery(float battery) {
        this.battery = battery;
        return this;
    }

    public String getId() {
        return id;
    }

    public Team setId(String id) {
        this.id = id;
        return this;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public Team setPositions(List<Position> positions) {
        this.positions = positions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Float.compare(team.battery, battery) == 0 && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, battery);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", battery=" + battery +
                '}';
    }
}
