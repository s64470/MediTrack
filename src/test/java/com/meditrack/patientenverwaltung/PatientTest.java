package com.meditrack.patientenverwaltung;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void patientKannMitGueltigenDatenErstelltWerden() {

        Patient patient = new Patient(
                1,
                "Anna",
                "Müller",
                "Lübeck",
                "01761234567",
                "anna.mueller@test.de"
        );

        assertNotNull(patient);
        assertEquals("Anna", patient.getVorname());
        assertEquals("Müller", patient.getNachname());
    }

    @Test
    void patientDarfKeineLeerenVornamenHaben() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Patient(
                    2,
                    "",
                    "Müller",
                    "Lübeck",
                    "01761234567",
                    "anna.mueller@test.de"
            );
        });
    }
    @Test
    void patientDarfKeinenLeerenNachnamenHaben() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Patient(
                    3,
                    "Anna",
                    "",
                    "Lübeck",
                    "01761234567",
                    "anna.mueller@test.de"
            );
        });
    }
    @Test
    void patientDarfKeineUngueltigeEmailHaben() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Patient(
                    4,
                    "Anna",
                    "Müller",
                    "Lübeck",
                    "01761234567",
                    "keine-email"
            );
        });
    }

    @Test
    void patientDarfKeineUngueltigeTelefonnummerHaben() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Patient(
                    5,
                    "Anna",
                    "Müller",
                    "Lübeck",
                    "abc123",
                    "anna.mueller@test.de"
            );
        });
    }
    @Test
    void patientDarfKeineLeereTelefonnummerHaben() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Patient(
                    6,
                    "Anna",
                    "Müller",
                    "Lübeck",
                    "",
                    "anna.mueller@test.de"
            );
        });
    }
    @Test
    void patientDarfKeineEmailOhneAtZeichenHaben() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Patient(
                    7,
                    "Anna",
                    "Müller",
                    "Lübeck",
                    "01761234567",
                    "annamuellertest.de"
            );
        });
    }
}