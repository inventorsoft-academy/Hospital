package com.inventorsoft.hospital.demo;

import com.inventorsoft.hospital.model.hospital.Hospital;
import com.inventorsoft.hospital.model.services.FileWork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital=new Hospital();
        do {
            System.out.println("Select variant \n 1 - Show all doctor \n 2 - Add doctor \n 3 - Save system state \n" +
                    "4 - Load system state \n 5 - Exit system");
            Scanner scan = new Scanner(System.in);
            int var = scan.nextInt();
            switch (var) {
                case 1: {
                    //all doc


                    break;
                }
                case 2: {
                    //add


                    break;
                }
                case 3: {
                    //save
                    FileWork.SaveFile();
                    break;
                }
                case 4: {
                    //load
                    FileWork.LoadFile();

                    break;
                }
                case 5: {
                    //exit

                    break;
                }
                default: {
                    System.out.println("Error input!!");
                }
            }
        } while (true);
    }
}
