package Dokumentenverwaltung;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UeberweisungTest {

    @Test
    void gueltigeUeberweisungErstellen() {
        Ueberweisung u = new Ueberweisung(
                1L,
                10L,
                20L,
                "Orthopädie",
                LocalDate.of(2026, 11, 9),
                "Untersuchung des Knies"
        );

        assertEquals(1L, u.id());
        assertEquals(10L, u.patientId());
        assertEquals(20L, u.arztId());
        assertEquals("Orthopädie", u.fachrichtung());
        assertEquals(
                LocalDate.of(2026, 11, 9),
                u.ausstellungsDatum()
        );
        assertEquals(
                "Untersuchung des Knies",
                u.begruendung()
        );
    }

    @Test
    void fachrichtungMitSonderzeichenIstErlaubt() {
        assertDoesNotThrow(() -> new Ueberweisung(
                1L, 10L, 20L,
                "HNO / Hals-Nasen-Ohren",
                LocalDate.of(2026, 11, 9),
                "Kontrolle"
        ));
    }

    @Test
    void langeBegruendungIstErlaubt() {
        assertDoesNotThrow(() -> new Ueberweisung(
                1L, 10L, 20L,
                "Orthopädie",
                LocalDate.of(2026, 11, 9),
                "Ausführliche medizinische Begründung mit mehreren Details."
        ));
    }

    @Test
    void idDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        null, 10L, 20L, "Orthopädie",
                        LocalDate.of(2026, 11, 9), "Kontrolle"
                ));
    }

    @Test
    void patientIdDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        1L, null, 20L, "Orthopädie",
                        LocalDate.of(2026, 11, 9), "Kontrolle"
                ));
    }

    @Test
    void arztIdDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        1L, 10L, null, "Orthopädie",
                        LocalDate.of(2026, 11, 9), "Kontrolle"
                ));
    }

    @Test
    void fachrichtungDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        1L, 10L, 20L, null,
                        LocalDate.of(2026, 11, 9), "Kontrolle"
                ));
    }

    @Test
    void fachrichtungDarfNichtLeerSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        1L, 10L, 20L, "   ",
                        LocalDate.of(2026, 11, 9), "Kontrolle"
                ));
    }

    @Test
    void ausstellungsDatumDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        1L, 10L, 20L, "Orthopädie",
                        null, "Kontrolle"
                ));
    }

    @Test
    void begruendungDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        1L, 10L, 20L, "Orthopädie",
                        LocalDate.of(2026, 11, 9), null
                ));
    }

    @Test
    void begruendungDarfNichtLeerSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ueberweisung(
                        1L, 10L, 20L, "Orthopädie",
                        LocalDate.of(2026, 11, 9), "   "
                ));
    }
}
