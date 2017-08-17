package com.inventorsoft.hospital.demo;

import com.inventorsoft.hospital.model.person.Person;
import com.inventorsoft.hospital.model.services.ConsoleUserInterface;
import com.inventorsoft.hospital.model.services.FileWork;

public class Main {
    public static void main(String[] args) {
        Person.setN(new FileWork().loadID());
        ConsoleUserInterface console = new ConsoleUserInterface();
        console.run();
    }
}