package co.inventorsoft.academy.hospital.doa;

import co.inventorsoft.academy.hospital.model.Hospital;

public interface DataManager {
    boolean save(Hospital hospital);

    boolean load(Hospital hospital);
}
