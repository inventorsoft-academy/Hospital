package com.inventorsoft.hospital.model.hospital;

import com.inventorsoft.hospital.model.people.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    public List <Doctor> doctors;

    public Hospital(){
        doctors=new ArrayList<>();
    }

    public boolean addDoctor(Doctor doctor){



        return true;
    }

    public String showAllDoctor(){
        String rez="";


        return rez;
    }


}
