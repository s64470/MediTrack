package Terminmanagement;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TerminTest {

    @Test
    void terminKannErstelltWerden() {
        Termin termin = new Termin(
                1L, 10L, 20L,
                LocalDateTime.now().plusDays(1),
                "Kontrolltermin"
        );

        assertEquals(1L, termin.getId());
        assertEquals(10L, termin.getPatientId());
        assertEquals(20L, termin.getArztId());
        assertEquals("Kontrolltermin", termin.getBeschreibung());
        assertEquals(TerminStatus.GEBUCHT, termin.getStatus());
    }

    @Test
    void terminKannStorniertWerden() {
        Termin termin = new Termin(
                2L, 11L, 21L,
                LocalDateTime.now().plusDays(2),
                "Nachuntersuchung"
        );

        termin.stornieren();

        assertEquals(TerminStatus.STORNIERT, termin.getStatus());
    }

    @Test
    void terminOhnePatientWirdAbgelehnt() {
        assertThrows(IllegalArgumentException.class, () ->
                new Termin(3L, null, 20L,
                        LocalDateTime.now().plusDays(1),
                        "Kontrolltermin")
        );
    }

    @Test
    void terminOhneArztWirdAbgelehnt() {
        assertThrows(IllegalArgumentException.class, () ->
                new Termin(4L, 10L, null,
                        LocalDateTime.now().plusDays(1),
                        "Kontrolltermin")
        );
    }

    @Test
    void terminOhneDatumWirdAbgelehnt() {
        assertThrows(IllegalArgumentException.class, () ->
                new Termin(5L, 10L, 20L, null,
                        "Kontrolltermin")
        );
    }

    @Test
    void terminInDerVergangenheitWirdAbgelehnt() {
        assertThrows(IllegalArgumentException.class, () ->
                new Termin(6L, 10L, 20L,
                        LocalDateTime.now().minusDays(1),
                        "Vergangener Termin")
        );
    }

    @Test
    void bereitsStornierterTerminBleibtStorniert() {
        Termin termin = new Termin(
                7L, 10L, 20L,
                LocalDateTime.now().plusDays(2),
                "Kontrolltermin"
        );

        termin.stornieren();
        termin.stornieren();

        assertEquals(TerminStatus.STORNIERT, termin.getStatus());
    }

    @Test
    void terminKannGebuchtWerden() {
        TerminRepository repository = new TerminRepository();
        TerminService service = new TerminService(repository);

        Termin termin = new Termin(
                8L, 10L, 20L,
                LocalDateTime.now().plusDays(1),
                "Neuer Termin"
        );

        service.terminBuchen(termin);

        assertEquals(1, repository.findeAlle().size());
        assertEquals(termin, repository.findeAlle().get(0));
    }

    @Test
    void terminKannUeberServiceStorniertWerden() {
        TerminRepository repository = new TerminRepository();
        TerminService service = new TerminService(repository);

        Termin termin = new Termin(
                9L, 10L, 20L,
                LocalDateTime.now().plusDays(2),
                "Kontrolltermin"
        );

        service.terminBuchen(termin);
        service.terminStornieren(termin);

        assertEquals(TerminStatus.STORNIERT, termin.getStatus());
    }

    @Test
    void nullTerminKannNichtGebuchtWerden() {
        TerminRepository repository = new TerminRepository();
        TerminService service = new TerminService(repository);

        assertThrows(IllegalArgumentException.class, () ->
                service.terminBuchen(null)
        );
    }

    @Test
    void nullTerminKannNichtStorniertWerden() {
        TerminRepository repository = new TerminRepository();
        TerminService service = new TerminService(repository);

        assertThrows(IllegalArgumentException.class, () ->
                service.terminStornieren(null)
        );
    }

    @Test
    void serviceOhneRepositoryWirdAbgelehnt() {
        assertThrows(IllegalArgumentException.class, () ->
                new TerminService(null)
        );
    }

    @Test
    void terminOhneIdWirdAbgelehnt() {
        assertThrows(IllegalArgumentException.class, () ->
                new Termin(
                        null,
                        10L,
                        20L,
                        LocalDateTime.now().plusDays(1),
                        "Kontrolltermin"
                )
        );
    }
}