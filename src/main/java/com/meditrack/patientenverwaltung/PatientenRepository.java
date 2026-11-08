package com.meditrack.patientenverwaltung;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientenRepository {

    private final List<Patient> patienten = new ArrayList<>();

    public void speichern(Patient patient) {

        if (patient == null) {
            throw new IllegalArgumentException(
                    "Patient darf nicht null sein."
            );
        }

        if (suchenNachId(patient.getPatientId()).isPresent()) {
            throw new IllegalArgumentException(
                    "Patient mit dieser ID existiert bereits."
            );
        }

        patienten.add(patient);
    }

    public Optional<Patient> suchenNachId(int patientId) {
        return patienten.stream()
                .filter(patient -> patient.getPatientId() == patientId)
                .findFirst();
    }
}