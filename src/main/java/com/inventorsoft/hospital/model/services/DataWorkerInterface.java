package com.inventorsoft.hospital.model.services;

import com.inventorsoft.hospital.model.hospital.Hospital;

public interface DataWorkerInterface {
    boolean save(Hospital hospital);
    boolean load(Hospital hospital);
}
