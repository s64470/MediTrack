package com.meditrack.behandlungsmanagement;

import java.time.LocalDate;

public class Behandlung {

    private int behandlungId;
    private int patientId;
    private LocalDate datum;
    private String diagnose;
    private String beschreibung;

    public Behandlung(int behandlungId, int patientId,
                      LocalDate datum, String diagnose,
                      String beschreibung) {

        if (patientId <= 0) {
            throw new IllegalArgumentException(
                    "Patienten-ID muss positiv sein."
            );
        }

        if (datum == null) {
            throw new IllegalArgumentException(
                    "Behandlungsdatum darf nicht fehlen."
            );
        }

        if (diagnose == null || diagnose.isBlank()) {
            throw new IllegalArgumentException(
                    "Diagnose darf nicht leer sein."
            );
        }

        this.behandlungId = behandlungId;
        this.patientId = patientId;
        this.datum = datum;
        this.diagnose = diagnose;
        this.beschreibung = beschreibung;
    }

    public int getBehandlungId() {
        return behandlungId;
    }

    public int getPatientId() {
        return patientId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}