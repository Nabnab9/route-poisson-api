package fr.perchandcobs.routepoissonapi.dto;

import fr.perchandcobs.routepoissonapi.domain.Member;

import java.util.List;
import java.util.Objects;

public class RTeam {

    private String name;

    private float battery;

    private String letter = "A";

    private List<Member> members;

    public String getName() {
        return name;
    }

    public RTeam setName(String name) {
        this.name = name;
        return this;
    }

    public float getBattery() {
        return battery;
    }

    public RTeam setBattery(float battery) {
        this.battery = battery;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RTeam team = (RTeam) o;
        return Float.compare(team.battery, battery) == 0 && Objects.equals(name, team.name);
    }

    public String getLetter() {
        return letter;
    }

    public RTeam setLetter(String letter) {
        this.letter = letter;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, battery);
    }

    @Override
    public String toString() {
        return "RTeam{" +
                "name='" + name + '\'' +
                ", battery=" + battery +
                '}';
    }

    public List<Member> getMembers() {
        return members;
    }

    public RTeam setMembers(List<Member> members) {
        this.members = members;
        return this;
    }
}
