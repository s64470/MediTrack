package com.meditrack.behandlungsmanagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UeberweisungTest {

    @Test
    void ueberweisungErfolgreichErstellen() {
        Ueberweisung ueberweisung = new Ueberweisung(
                1,
                100,
                LocalDate.of(2026, 11, 8),
                "Kardiologie",
                "Abklärung von Herzbeschwerden"
        );

        assertEquals(1, ueberweisung.getUeberweisungId());
        assertEquals(100, ueberweisung.getPatientId());
        assertEquals(LocalDate.of(2026, 11, 8), ueberweisung.getDatum());
        assertEquals("Kardiologie", ueberweisung.getFachrichtung());
        assertEquals("Abklärung von Herzbeschwerden", ueberweisung.getGrund());
    }
    @Test
    void ueberweisungOhneFachrichtungAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        2,
                        100,
                        LocalDate.of(2026, 11, 8),
                        "",
                        "Abklärung von Herzbeschwerden"
                )
        );
    }
    @Test
    void ueberweisungOhneDatumAblehnen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        2,
                        100,
                        null,
                        "Orthopädie",
                        "Rückenschmerzen"
                )
        );
    }
}