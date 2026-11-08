package Dokumentenverwaltung;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class KrankschreibungRepositoryTest {

    private InMemoryKrankschreibungRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryKrankschreibungRepository();
    }

    private Krankschreibung beispielKrankschreibung() {
        return new Krankschreibung(
                1L,
                10L,
                20L,
                LocalDate.of(2026, 11, 9),
                LocalDate.of(2026, 11, 13),
                "Grippe"
        );
    }

    @Test
    void krankschreibungErfolgreichSpeichern() {
        Krankschreibung k = beispielKrankschreibung();

        repository.speichern(k);

        assertTrue(repository.findeNachId(1L).isPresent());
    }

    @Test
    void gespeicherteKrankschreibungFinden() {
        Krankschreibung k = beispielKrankschreibung();
        repository.speichern(k);

        assertEquals(
                k,
                repository.findeNachId(1L).orElseThrow()
        );
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
    void alleKrankschreibungenZurueckgeben() {
        repository.speichern(beispielKrankschreibung());

        Krankschreibung zweite = new Krankschreibung(
                2L,
                11L,
                21L,
                LocalDate.of(2026, 11, 10),
                LocalDate.of(2026, 11, 14),
                "Erkältung"
        );

        repository.speichern(zweite);

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
        KrankschreibungRepository repository =
                new InMemoryKrankschreibungRepository();

        Krankschreibung erste = new Krankschreibung(
                1L,
                10L,
                20L,
                LocalDate.of(2026, 11, 9),
                LocalDate.of(2026, 11, 12),
                "Erste Begründung"
        );

        Krankschreibung zweite = new Krankschreibung(
                1L,
                11L,
                21L,
                LocalDate.of(2026, 11, 10),
                LocalDate.of(2026, 11, 13),
                "Zweite Begründung"
        );

        repository.speichern(erste);

        assertThrows(
                IllegalArgumentException.class,
                () -> repository.speichern(zweite)
        );

        assertEquals(erste, repository.findeNachId(1L).orElseThrow());
    }
}

