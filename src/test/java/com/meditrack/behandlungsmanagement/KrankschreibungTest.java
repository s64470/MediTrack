package com.meditrack.behandlungsmanagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KrankschreibungTest {

    @Test
    void krankschreibungErfolgreichErstellen() {
        Krankschreibung krankschreibung = new Krankschreibung(
                1,
                100,
                LocalDate.of(2026, 11, 8),
                LocalDate.of(2026, 11, 15),
                "Grippe"
        );

        assertEquals(1, krankschreibung.getKrankschreibungId());
        assertEquals(100, krankschreibung.getPatientId());
        assertEquals(LocalDate.of(2026, 11, 8), krankschreibung.getBeginn());
        assertEquals(LocalDate.of(2026, 11, 15), krankschreibung.getEnde());
        assertEquals("Grippe", krankschreibung.getGrund());
    }
    @Test
    void krankschreibungMitUngueltigemZeitraumAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        2,
                        100,
                        LocalDate.of(2026, 11, 15),
                        LocalDate.of(2026, 11, 8),
                        "Grippe"
                )
        );
    }
    @Test
    void krankschreibungMitFehlendemBeginnAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        2,
                        100,
                        null,
                        LocalDate.of(2026, 11, 15),
                        "Grippe"
                )
        );
    }
}