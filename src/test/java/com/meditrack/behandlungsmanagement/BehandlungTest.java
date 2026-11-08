package com.meditrack.behandlungsmanagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BehandlungTest {

    @Test
    void behandlungErfolgreichErstellen() {
        Behandlung behandlung = new Behandlung(
                1,
                100,
                LocalDate.of(2026, 11, 8),
                "Grippe",
                "Patient wurde untersucht."
        );

        assertEquals(1, behandlung.getBehandlungId());
        assertEquals(100, behandlung.getPatientId());
        assertEquals(LocalDate.of(2026, 11, 8), behandlung.getDatum());
        assertEquals("Grippe", behandlung.getDiagnose());
        assertEquals("Patient wurde untersucht.", behandlung.getBeschreibung());
    }
    @Test
    void behandlungMitLeeremDiagnosetextAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Behandlung(
                        2,
                        100,
                        LocalDate.of(2026, 11, 8),
                        "",
                        "Patient wurde untersucht."
                )
        );
    }
    @Test
    void behandlungOhneDatumAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Behandlung(
                        3,
                        100,
                        null,
                        "Grippe",
                        "Patient wurde untersucht."
                )
        );
    }
    @Test
    void behandlungMitUngueltigerPatientenIdAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Behandlung(
                        1,
                        0,
                        LocalDate.of(2026, 11, 8),
                        "Grippe",
                        "Patient wurde untersucht."
                )
        );
    }
}