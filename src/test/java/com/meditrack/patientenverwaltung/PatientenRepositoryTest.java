package com.meditrack.patientenverwaltung;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PatientenRepositoryTest {

    @Test
    void gespeichertenPatientenAnhandDerIdFinden() {
        PatientenRepository repository = new PatientenRepository();

        Patient patient = new Patient(
                1, "Max", "Mustermann",
                "Musterstraße 1", "123456789", "max@test.de"
        );

        repository.speichern(patient);

        Optional<Patient> ergebnis = repository.suchenNachId(1);

        assertTrue(ergebnis.isPresent());
        assertEquals(patient, ergebnis.get());
    }

    @Test
    void beiUnbekannterIdLeeresOptionalZurueckgeben() {
        PatientenRepository repository = new PatientenRepository();

        Optional<Patient> ergebnis = repository.suchenNachId(99);

        assertTrue(ergebnis.isEmpty());
    }
    @Test
    void doppeltePatientenIdDarfNichtGespeichertWerden() {
        PatientenRepository repository = new PatientenRepository();

        Patient patient1 = new Patient(
                1, "Max", "Mustermann",
                "Musterstraße 1", "123456789", "max@test.de"
        );

        Patient patient2 = new Patient(
                1, "Anna", "Musterfrau",
                "Musterstraße 2", "987654321", "anna@test.de"
        );

        repository.speichern(patient1);

        assertThrows(IllegalArgumentException.class,
                () -> repository.speichern(patient2));
    }
    @Test
    void nullDarfNichtGespeichertWerden() {
        PatientenRepository repository = new PatientenRepository();

        assertThrows(IllegalArgumentException.class,
                () -> repository.speichern(null));
    }
    @Test
    void patientKontaktRecordSpeichertKontaktdaten() {
        PatientKontakt kontakt = new PatientKontakt(
                "123456789",
                "max@test.de"
        );

        assertEquals("123456789", kontakt.telefonnummer());
        assertEquals("max@test.de", kontakt.email());
    }
}