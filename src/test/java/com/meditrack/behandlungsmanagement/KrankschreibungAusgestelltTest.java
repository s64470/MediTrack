package com.meditrack.behandlungsmanagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KrankschreibungAusgestelltTest {

    @Test
    void eventErfolgreichErstellen() {
        LocalDate beginn = LocalDate.of(2026, 11, 8);
        LocalDate ende = LocalDate.of(2026, 11, 15);

        KrankschreibungAusgestellt event =
                new KrankschreibungAusgestellt(1, 100, beginn, ende);

        assertEquals(1, event.krankschreibungId());
        assertEquals(100, event.patientId());
        assertEquals(beginn, event.beginn());
        assertEquals(ende, event.ende());
    }

    @Test
    void eventMitUngueltigemZeitraumAblehnen() {
        LocalDate beginn = LocalDate.of(2026, 11, 15);
        LocalDate ende = LocalDate.of(2026, 11, 8);

        assertThrows(IllegalArgumentException.class, () ->
                new KrankschreibungAusgestellt(1, 100, beginn, ende)
        );
    }

    @Test
    void eventOhneBeginnAblehnen() {
        LocalDate ende = LocalDate.of(2026, 11, 15);

        assertThrows(IllegalArgumentException.class, () ->
                new KrankschreibungAusgestellt(1, 100, null, ende)
        );
    }
}