package com.inventorsoft.hospital.model.person;

import com.inventorsoft.hospital.services.MyValidator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class Person implements MyValidator {
    private static int n;

    protected int num;

    @NotNull(message = "last name mast be given")
    @Size(min = 3, message = "last name mas be min size 3 characters")
    protected String lastName;

    @NotNull(message = "first name mast be given")
    protected String firstName;

    protected Gender gender;

    Person(String lastName, String firstName, String gender) {
        n++;
        num = n;
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

    public static void setN(int n) {
        Person.n = n;
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

    public void setNum(int num) {
        this.num = num;
    }
}