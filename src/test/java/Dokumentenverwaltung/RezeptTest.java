package Dokumentenverwaltung;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RezeptTest {

    @Test
    void gueltigesRezeptErstellen() {
        Rezept rezept = new Rezept(
                1L,
                10L,
                20L,
                "Medikament A",
                "1 Tablette täglich",
                LocalDate.of(2026, 11, 9),
                "Mit ausreichend Wasser einnehmen"
        );

        assertEquals(1L, rezept.id());
        assertEquals(10L, rezept.patientId());
        assertEquals(20L, rezept.arztId());
        assertEquals("Medikament A", rezept.medikament());
        assertEquals("1 Tablette täglich", rezept.dosierung());
        assertEquals(
                LocalDate.of(2026, 11, 9),
                rezept.ausstellungsDatum()
        );
        assertEquals(
                "Mit ausreichend Wasser einnehmen",
                rezept.anweisungen()
        );
    }

    @Test
    void idDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rezept(null, 10L, 20L, "Medikament A",
                        "1 Tablette täglich", LocalDate.now(), "Hinweis"));
    }

    @Test
    void patientIdDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rezept(1L, null, 20L, "Medikament A",
                        "1 Tablette täglich", LocalDate.now(), "Hinweis"));
    }

    @Test
    void arztIdDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rezept(1L, 10L, null, "Medikament A",
                        "1 Tablette täglich", LocalDate.now(), "Hinweis"));
    }

    @Test
    void medikamentDarfNichtLeerSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rezept(1L, 10L, 20L, " ",
                        "1 Tablette täglich", LocalDate.now(), "Hinweis"));
    }

    @Test
    void dosierungDarfNichtLeerSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rezept(1L, 10L, 20L, "Medikament A",
                        " ", LocalDate.now(), "Hinweis"));
    }

    @Test
    void ausstellungsDatumDarfNichtNullSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rezept(1L, 10L, 20L, "Medikament A",
                        "1 Tablette täglich", null, "Hinweis"));
    }

    @Test
    void anweisungenDuerfenNichtLeerSein() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rezept(1L, 10L, 20L, "Medikament A",
                        "1 Tablette täglich", LocalDate.now(), " "));
    }
}