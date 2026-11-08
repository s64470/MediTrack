package Dokumentenverwaltung;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class KrankschreibungTest {

    @Test
    void gueltigeKrankschreibungErstellen() {
        Krankschreibung k = new Krankschreibung(
                1L, 10L, 20L,
                LocalDate.of(2026, 11, 9),
                LocalDate.of(2026, 11, 13),
                "Grippe"
        );

        assertEquals(1L, k.getId());
        assertEquals(10L, k.getPatientId());
        assertEquals(20L, k.getArztId());
        assertEquals("Grippe", k.getBegruendung());
    }

    @Test
    void enddatumDarfGleichStartdatumSein() {
        assertDoesNotThrow(() -> new Krankschreibung(
                1L, 10L, 20L,
                LocalDate.of(2026, 11, 9),
                LocalDate.of(2026, 11, 9),
                "Grippe"
        ));
    }

    @Test
    void idDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        null, 10L, 20L,
                        LocalDate.of(2026, 11, 9),
                        LocalDate.of(2026, 11, 13),
                        "Grippe"
                ));
    }

    @Test
    void patientIdDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        1L, null, 20L,
                        LocalDate.of(2026, 11, 9),
                        LocalDate.of(2026, 11, 13),
                        "Grippe"
                ));
    }

    @Test
    void arztIdDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        1L, 10L, null,
                        LocalDate.of(2026, 11, 9),
                        LocalDate.of(2026, 11, 13),
                        "Grippe"
                ));
    }

    @Test
    void startdatumDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        1L, 10L, 20L,
                        null,
                        LocalDate.of(2026, 11, 13),
                        "Grippe"
                ));
    }

    @Test
    void enddatumDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        1L, 10L, 20L,
                        LocalDate.of(2026, 11, 9),
                        null,
                        "Grippe"
                ));
    }

    @Test
    void enddatumDarfNichtVorStartdatumLiegen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        1L, 10L, 20L,
                        LocalDate.of(2026, 11, 13),
                        LocalDate.of(2026, 11, 9),
                        "Grippe"
                ));
    }

    @Test
    void begruendungDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        1L, 10L, 20L,
                        LocalDate.of(2026, 11, 9),
                        LocalDate.of(2026, 11, 13),
                        null
                ));
    }

    @Test
    void begruendungDarfNichtLeerSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Krankschreibung(
                        1L, 10L, 20L,
                        LocalDate.of(2026, 11, 9),
                        LocalDate.of(2026, 11, 13),
                        "   "
                ));
    }
    @Test
    void begruendungMitSonderzeichenIstErlaubt() {
        assertDoesNotThrow(() -> new Krankschreibung(
                1L, 10L, 20L,
                LocalDate.of(2026, 11, 9),
                LocalDate.of(2026, 11, 13),
                "Grippe, Fieber und Husten!"
        ));
    }

    @Test
    void begruendungMitLeerzeichenAmRandIstErlaubt() {
        assertDoesNotThrow(() -> new Krankschreibung(
                1L, 10L, 20L,
                LocalDate.of(2026, 11, 9),
                LocalDate.of(2026, 11, 13),
                " Grippe "
        ));
    }

    @Test
    void langeBegruendungIstErlaubt() {
        assertDoesNotThrow(() -> new Krankschreibung(
                1L, 10L, 20L,
                LocalDate.of(2026, 11, 9),
                LocalDate.of(2026, 11, 13),
                "Längere medizinische Begründung mit mehreren Angaben und zusätzlichen Details."
        ));
    }
}
