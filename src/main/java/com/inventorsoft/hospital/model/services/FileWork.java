package com.inventorsoft.hospital.model.services;

import com.inventorsoft.hospital.model.diagnose.Diagnose;
import com.inventorsoft.hospital.model.hospital.Hospital;
import com.inventorsoft.hospital.model.person.Doctor;
import com.inventorsoft.hospital.model.person.Patient;

import java.io.File;
import java.io.*;

public class FileWork implements DataWorkerInterface {
    private static File file=new File("data.txt");

    @Override
    public boolean save(Hospital hospital) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
            for (Doctor d : hospital.getDoctors()){
                writer.write(d.toString());
                writer.append('\n');
                for (Patient p:d.getPatients()){
                    writer.write(p.toString());
                    writer.append('\n');
                    for (Diagnose diag : p.getDiagnoses()){
                        writer.write(diag.toString());
                        writer.write('\n');
                    }
                    writer.write('\n');
                }
                writer.write('\n');
            }

            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean load(Hospital hospital) {
        try(FileReader reader = new FileReader(file))
        {
            return true;
        }
        catch(IOException ex){
            return false;
        }
    }
}
