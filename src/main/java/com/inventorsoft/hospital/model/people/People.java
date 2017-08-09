package com.inventorsoft.hospital.model.people;

public abstract class People {
    private static int n;
    protected int num;
    protected String lastName;
    protected String firstName;
    protected Gender gender;

    public People(String lastName, String firstName, String gender) {
        n++;
        num=n;
        this.lastName = lastName;
        this.firstName = firstName;
        switch (gender) {
            case "M":
                this.gender = Gender.MALE;
                break;
            default:
                this.gender = Gender.FEMALE;
        }
    }
}
