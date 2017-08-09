package com.inventorsoft.hospital.model.people;

public abstract class People {
    private static int n;
    protected int num;
    protected String lastName;
    protected String firstName;
    protected Gender gender;

    People(String lastName, String firstName, String gender) {
        n++;
        num=n;
        this.lastName = lastName;
        this.firstName = firstName;
        switch (gender) {
            case "m":
                this.gender = Gender.MALE;
                break;
            default:
                this.gender = Gender.FEMALE;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender.toString();
    }

    public int getNum() {
        return num;
    }
}
