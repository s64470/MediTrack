package Terminmanagement;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TerminRepositoryTest {

    @Test
    void repositoryIstAmAnfangLeer() {
        TerminRepository repository = new TerminRepository();

        assertTrue(repository.findeAlle().isEmpty());
    }

    @Test
    void terminKannGespeichertWerden() {
        TerminRepository repository = new TerminRepository();

        Termin termin = new Termin(
                1L, 10L, 20L,
                LocalDateTime.now().plusDays(1),
                "Kontrolltermin"
        );

        repository.speichern(termin);

        assertEquals(1, repository.findeAlle().size());
        assertEquals(termin, repository.findeAlle().get(0));
    }

    @Test
    void nullTerminKannNichtGespeichertWerden() {
        TerminRepository repository = new TerminRepository();

        assertThrows(IllegalArgumentException.class, () ->
                repository.speichern(null)
        );
    }

    @Test
    void externeListeKannRepositoryNichtVerändern() {
        TerminRepository repository = new TerminRepository();

        Termin termin = new Termin(
                2L, 10L, 20L,
                LocalDateTime.now().plusDays(2),
                "Nachuntersuchung"
        );

        repository.speichern(termin);

        repository.findeAlle().clear();

        assertEquals(1, repository.findeAlle().size());
    }

    @Test
    void doppelteIdDarfNichtGespeichertWerden() {
        TerminRepository repository = new TerminRepository();

        Termin erster = new Termin(
                1L, 10L, 20L,
                LocalDateTime.now().plusDays(1),
                "Erster Termin"
        );

        Termin zweiter = new Termin(
                1L, 11L, 21L,
                LocalDateTime.now().plusDays(2),
                "Zweiter Termin"
        );

        repository.speichern(erster);

        assertThrows(
                IllegalArgumentException.class,
                () -> repository.speichern(zweiter)
        );

        assertEquals(1, repository.findeAlle().size());
    }
}