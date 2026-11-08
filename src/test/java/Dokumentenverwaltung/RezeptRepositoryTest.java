package Dokumentenverwaltung;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RezeptRepositoryTest {

    private Rezept erstelleRezept(Long id) {
        return new Rezept(
                id,
                10L,
                20L,
                "Medikament A",
                "1 Tablette täglich",
                LocalDate.of(2026, 11, 9),
                "Mit Wasser einnehmen"
        );
    }

    @Test
    void rezeptSpeichern() {
        RezeptRepository repository =
                new InMemoryRezeptRepository();

        Rezept rezept = erstelleRezept(1L);

        repository.speichern(rezept);

        assertEquals(1, repository.findeAlle().size());
    }

    @Test
    void rezeptNachIdFinden() {
        RezeptRepository repository =
                new InMemoryRezeptRepository();

        Rezept rezept = erstelleRezept(1L);
        repository.speichern(rezept);

        Optional<Rezept> gefunden =
                repository.findeNachId(1L);

        assertTrue(gefunden.isPresent());
        assertEquals(rezept, gefunden.get());
    }

    @Test
    void unbekannteIdLiefertLeeresOptional() {
        RezeptRepository repository =
                new InMemoryRezeptRepository();

        assertTrue(repository.findeNachId(99L).isEmpty());
    }

    @Test
    void nullIdLiefertLeeresOptional() {
        RezeptRepository repository =
                new InMemoryRezeptRepository();

        assertTrue(repository.findeNachId(null).isEmpty());
    }

    @Test
    void alleRezepteFinden() {
        RezeptRepository repository =
                new InMemoryRezeptRepository();

        repository.speichern(erstelleRezept(1L));
        repository.speichern(erstelleRezept(2L));

        assertEquals(2, repository.findeAlle().size());
    }

    @Test
    void nullDarfNichtGespeichertWerden() {
        RezeptRepository repository =
                new InMemoryRezeptRepository();

        assertThrows(
                IllegalArgumentException.class,
                () -> repository.speichern(null)
        );
    }
    @Test
    void doppelteIdDarfNichtGespeichertWerden() {
        RezeptRepository repository =
                new InMemoryRezeptRepository();

        Rezept erstes = new Rezept(
                1L,
                10L,
                20L,
                "Medikament A",
                "1 Tablette täglich",
                LocalDate.of(2026, 11, 9),
                "Erste Anweisung"
        );

        Rezept zweites = new Rezept(
                1L,
                11L,
                21L,
                "Medikament B",
                "2 Tabletten täglich",
                LocalDate.of(2026, 11, 10),
                "Zweite Anweisung"
        );

        repository.speichern(erstes);

        assertThrows(
                IllegalArgumentException.class,
                () -> repository.speichern(zweites)
        );

        assertEquals(
                erstes,
                repository.findeNachId(1L).orElseThrow()
        );
    }
}
