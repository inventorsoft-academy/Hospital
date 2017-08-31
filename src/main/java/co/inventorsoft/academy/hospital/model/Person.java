package co.inventorsoft.academy.hospital.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public abstract class Person {
    private static int n;

    protected int num;

    @NotNull(message = "last name mast be given")
    @Size(min = 3, message = "last name mas be min size 3 characters")
    protected String lastName;

    @NotNull(message = "first name mast be given")
    protected String firstName;
    protected Gender gender;

    Person(final String lastName, final String firstName, final String gender) {
        n++;
        num = n;
        this.lastName = lastName;
        this.firstName = firstName;
        switch (gender) {
            case "MALE":
                this.gender = Gender.MALE;
                break;
            default:
                this.gender = Gender.FEMALE;
        }
    }

    public static void setN(final int n) {
        Person.n = n;
    }

    public void setNum(final int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender.toString();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private enum Gender {
        MALE,
        FEMALE
    }
}