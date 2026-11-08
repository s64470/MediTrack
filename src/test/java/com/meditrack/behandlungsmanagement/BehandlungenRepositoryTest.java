package com.meditrack.behandlungsmanagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BehandlungenRepositoryTest {

    @Test
    void behandlungErfolgreichSpeichern() {
        BehandlungenRepository repository = new BehandlungenRepository();

        Behandlung behandlung = new Behandlung(
                1,
                100,
                LocalDate.of(2026, 11, 8),
                "Grippe",
                "Patient wurde untersucht."
        );

        repository.speichern(behandlung);

        assertEquals(1, repository.alleFinden().size());
    }

    @Test
    void behandlungNachIdFinden() {
        BehandlungenRepository repository = new BehandlungenRepository();

        Behandlung behandlung = new Behandlung(
                1,
                100,
                LocalDate.of(2026, 11, 8),
                "Grippe",
                "Patient wurde untersucht."
        );

        repository.speichern(behandlung);

        assertTrue(repository.findenNachId(1).isPresent());
    }
}