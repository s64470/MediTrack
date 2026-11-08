package com.meditrack.behandlungsmanagement;

import java.time.LocalDate;

public class Ueberweisung {

    private int ueberweisungId;
    private int patientId;
    private LocalDate datum;
    private String fachrichtung;
    private String grund;

    public Ueberweisung(int ueberweisungId, int patientId,
                        LocalDate datum, String fachrichtung,
                        String grund) {

        if (fachrichtung == null || fachrichtung.isBlank()) {
            throw new IllegalArgumentException(
                    "Fachrichtung darf nicht leer sein."
            );
        }

        if (datum == null) {
            throw new IllegalArgumentException(
                    "Überweisungsdatum darf nicht fehlen."
            );
        }

        this.ueberweisungId = ueberweisungId;
        this.patientId = patientId;
        this.datum = datum;
        this.fachrichtung = fachrichtung;
        this.grund = grund;
    }

    public int getUeberweisungId() {
        return ueberweisungId;
    }

    public int getPatientId() {
        return patientId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getFachrichtung() {
        return fachrichtung;
    }

    public String getGrund() {
        return grund;
    }
}