package com.meditrack.behandlungsmanagement;

import java.time.LocalDate;

public class Krankschreibung {

    private int krankschreibungId;
    private int patientId;
    private LocalDate beginn;
    private LocalDate ende;
    private String grund;

    public Krankschreibung(int krankschreibungId, int patientId,
                           LocalDate beginn, LocalDate ende,
                           String grund) {

        if (beginn == null || ende == null) {
            throw new IllegalArgumentException(
                    "Beginn und Ende müssen angegeben werden."
            );
        }

        if (ende.isBefore(beginn)) {
            throw new IllegalArgumentException(
                    "Das Ende darf nicht vor dem Beginn liegen."
            );
        }

        this.krankschreibungId = krankschreibungId;
        this.patientId = patientId;
        this.beginn = beginn;
        this.ende = ende;
        this.grund = grund;
    }

    public int getKrankschreibungId() {
        return krankschreibungId;
    }

    public int getPatientId() {
        return patientId;
    }

    public LocalDate getBeginn() {
        return beginn;
    }

    public LocalDate getEnde() {
        return ende;
    }

    public String getGrund() {
        return grund;
    }
}