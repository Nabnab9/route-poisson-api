package fr.perchandcobs.routepoissonapi.dto;

public class RMember {

    private String name;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RMember setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public RMember setName(String name) {
        this.name = name;
        return this;
    }
}
