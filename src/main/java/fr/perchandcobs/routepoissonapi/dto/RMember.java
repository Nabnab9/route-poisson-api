package fr.perchandcobs.routepoissonapi.dto;

public class RMember {

    private String name;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RMember withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
