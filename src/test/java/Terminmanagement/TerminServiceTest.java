package Terminmanagement;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TerminServiceTest {

    @Test
    void gespeicherterTerminKannStorniertWerden() {
        TerminRepository repository = new TerminRepository();
        TerminService service = new TerminService(repository);

        Termin termin = new Termin(
                1L, 10L, 20L,
                LocalDateTime.now().plusDays(1),
                "Kontrolltermin"
        );

        service.terminBuchen(termin);
        service.terminStornieren(termin);

        assertEquals(TerminStatus.STORNIERT, termin.getStatus());
    }

    @Test
    void nichtGespeicherterTerminKannNichtStorniertWerden() {
        TerminRepository repository = new TerminRepository();
        TerminService service = new TerminService(repository);

        Termin termin = new Termin(
                2L, 10L, 20L,
                LocalDateTime.now().plusDays(2),
                "Nachuntersuchung"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.terminStornieren(termin)
        );

        assertEquals(TerminStatus.GEBUCHT, termin.getStatus());
    }

    @Test
    void nullTerminKannNichtGebuchtWerden() {
        TerminRepository repository = new TerminRepository();
        TerminService service = new TerminService(repository);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.terminBuchen(null)
        );
    }

    @Test
    void nullTerminKannNichtStorniertWerden() {
        TerminRepository repository = new TerminRepository();
        TerminService service = new TerminService(repository);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.terminStornieren(null)
        );
    }

    @Test
    void nullRepositoryIstNichtErlaubt() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TerminService(null)
        );
    }
}
