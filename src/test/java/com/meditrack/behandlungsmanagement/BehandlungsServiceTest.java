package com.meditrack.behandlungsmanagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BehandlungsServiceTest {

    @Test
    void behandlungSpeichernUndEventErzeugen() {
        BehandlungenRepository repository = new BehandlungenRepository();
        BehandlungsService service = new BehandlungsService(repository);

        Behandlung behandlung = new Behandlung(
                1,
                100,
                LocalDate.of(2026, 11, 8),
                "Grippe",
                "Patient wurde untersucht."
        );

        BehandlungDokumentiert event =
                service.behandlungDokumentieren(behandlung);

        assertEquals(1, repository.alleFinden().size());
        assertEquals(1, event.behandlungId());
        assertEquals(100, event.patientId());
    }

    @Test
    void serviceOhneRepositoryAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new BehandlungsService(null)
        );
    }

    @Test
    void fehlendeBehandlungAblehnen() {
        BehandlungsService service =
                new BehandlungsService(new BehandlungenRepository());

        assertThrows(IllegalArgumentException.class, () ->
                service.behandlungDokumentieren(null)
        );
    }
}