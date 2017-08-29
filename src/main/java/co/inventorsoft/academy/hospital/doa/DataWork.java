package co.inventorsoft.academy.hospital.doa;

import co.inventorsoft.academy.hospital.model.Hospital;

public interface DataWork {
    boolean save(Hospital hospital);

    boolean load(Hospital hospital);
}
