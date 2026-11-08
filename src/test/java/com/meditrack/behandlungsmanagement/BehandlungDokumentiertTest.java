package com.meditrack.behandlungsmanagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BehandlungDokumentiertTest {

    @Test
    void eventErfolgreichErstellen() {
        LocalDate datum = LocalDate.of(2026, 11, 8);

        BehandlungDokumentiert event =
                new BehandlungDokumentiert(1, 100, datum);

        assertEquals(1, event.behandlungId());
        assertEquals(100, event.patientId());
        assertEquals(datum, event.datum());
    }

    @Test
    void eventMitFehlendemDatumAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new BehandlungDokumentiert(1, 100, null)
        );
    }
}