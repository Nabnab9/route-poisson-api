package fr.perchandcobs.routepoissonapi.dto;

import fr.perchandcobs.routepoissonapi.domain.Team;

import java.time.LocalDateTime;
import java.util.Objects;


public class RPosition {

    private String id;

    private float longitude;
    private float latitude;
    private LocalDateTime dateTime;
    private float speed;
    private RTeam team;
    private float battery;
    private String serial;
    private String androidId;
    private float altitude;
    private float precision;



    public float getLongitude() {
        return longitude;
    }

    public RPosition setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public RPosition setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public RPosition setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public float getSpeed() {
        return speed;
    }

    public RPosition setSpeed(float speed) {
        this.speed = speed;
        return this;
    }

    public RTeam getTeam() {
        return team;
    }

    public RPosition setTeam(RTeam team) {
        this.team = team;
        return this;
    }

    public float getBattery() {
        return battery;
    }

    public RPosition setBattery(float battery) {
        this.battery = battery;
        return this;
    }

    public String getSerial() {
        return serial;
    }

    public RPosition setSerial(String serial) {
        this.serial = serial;
        return this;
    }

    public String getAndroidId() {
        return androidId;
    }

    public RPosition setAndroidId(String androidId) {
        this.androidId = androidId;
        return this;
    }

    public float getAltitude() {
        return altitude;
    }

    public RPosition setAltitude(float altitude) {
        this.altitude = altitude;
        return this;
    }

    public float getPrecision() {
        return precision;
    }

    public RPosition setPrecision(float precision) {
        this.precision = precision;
        return this;
    }

    public String getId() {
        return id;
    }

    public RPosition setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RPosition position = (RPosition) o;
        return Float.compare(position.longitude, longitude) == 0 && Float.compare(position.latitude, latitude) == 0 && Float.compare(position.speed, speed) == 0 && Float.compare(position.battery, battery) == 0 && Float.compare(position.altitude, altitude) == 0 && Float.compare(position.precision, precision) == 0 && Objects.equals(dateTime, position.dateTime) && Objects.equals(team, position.team) && Objects.equals(serial, position.serial) && Objects.equals(androidId, position.androidId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude, dateTime, speed, team, battery, serial, androidId, altitude, precision);
    }

    @Override
    public String toString() {
        return "Position{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", dateTime=" + dateTime +
                ", speed=" + speed +
                ", team=" + team +
                ", battery=" + battery +
                ", serial='" + serial + '\'' +
                ", androidId='" + androidId + '\'' +
                ", altitude=" + altitude +
                ", precision=" + precision +
                '}';
    }
}
