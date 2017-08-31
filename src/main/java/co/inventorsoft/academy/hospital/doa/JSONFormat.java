package co.inventorsoft.academy.hospital.doa;

import co.inventorsoft.academy.hospital.model.Hospital;
import co.inventorsoft.academy.hospital.model.Person;
import co.inventorsoft.academy.hospital.ui.ConsoleUserInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSONFormat implements DataManager {
    private final static File file = new File("src\\main\\resources\\data.json");

    @Override
    public boolean save(final Hospital hospital) {
        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();;
        try {
            mapper.writeValue(file, hospital);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean load(Hospital hospital) {
        ObjectMapper mapper = new ObjectMapper();
        Hospital h;
        try {
            h = mapper.readValue(file, Hospital.class);

        } catch (IOException e) {
            return false;
        }
        hospital.setDoctors(h.getDoctors());
        Person.setN(loadID());
        return true;
    }

    private static int loadID() {
        final File file = new File("src\\main\\resources\\data.txt");
        String line;
        int result = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                result = Integer.parseInt(line);
            }
            reader.close();
        } catch (IOException | NumberFormatException ex) {
            result = 0;
            ConsoleUserInterface.log.error(ex.getMessage());
        }
        return result;
    }
}