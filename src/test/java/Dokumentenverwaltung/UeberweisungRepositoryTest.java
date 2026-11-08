package Dokumentenverwaltung;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UeberweisungRepositoryTest {

    private InMemoryUeberweisungRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryUeberweisungRepository();
    }

    private Ueberweisung beispielUeberweisung(Long id) {
        return new Ueberweisung(
                id,
                10L,
                20L,
                "Orthopädie",
                LocalDate.of(2026, 11, 9),
                "Kontrolle"
        );
    }

    @Test
    void ueberweisungSpeichern() {
        Ueberweisung u = beispielUeberweisung(1L);

        repository.speichern(u);

        assertEquals(1, repository.findeAlle().size());
    }

    @Test
    void ueberweisungNachIdFinden() {
        Ueberweisung u = beispielUeberweisung(1L);
        repository.speichern(u);

        assertEquals(u, repository.findeNachId(1L).orElseThrow());
    }

    @Test
    void unbekannteIdLiefertLeeresOptional() {
        assertTrue(repository.findeNachId(99L).isEmpty());
    }

    @Test
    void nullIdLiefertLeeresOptional() {
        assertTrue(repository.findeNachId(null).isEmpty());
    }

    @Test
    void alleUeberweisungenFinden() {
        repository.speichern(beispielUeberweisung(1L));
        repository.speichern(beispielUeberweisung(2L));

        assertEquals(2, repository.findeAlle().size());
    }

    @Test
    void nullDarfNichtGespeichertWerden() {
        assertThrows(
                IllegalArgumentException.class,
                () -> repository.speichern(null)
        );
    }
    @Test
    void doppelteIdDarfNichtGespeichertWerden() {
        UeberweisungRepository repository =
                new InMemoryUeberweisungRepository();

        Ueberweisung erste = new Ueberweisung(
                1L,
                10L,
                20L,
                "Kardiologie",
                LocalDate.of(2026, 11, 9),
                "Erste Überweisung"
        );

        Ueberweisung zweite = new Ueberweisung(
                1L,
                11L,
                21L,
                "Orthopädie",
                LocalDate.of(2026, 11, 10),
                "Zweite Überweisung"
        );

        repository.speichern(erste);

        assertThrows(
                IllegalArgumentException.class,
                () -> repository.speichern(zweite)
        );

        assertEquals(
                erste,
                repository.findeNachId(1L).orElseThrow()
        );
    }
}
