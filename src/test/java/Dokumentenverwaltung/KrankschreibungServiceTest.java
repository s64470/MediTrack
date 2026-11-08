package Dokumentenverwaltung;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class KrankschreibungServiceTest {

    @Test
    void krankschreibungAusstellenUndSpeichern() {
        InMemoryKrankschreibungRepository repository =
                new InMemoryKrankschreibungRepository();

        KrankschreibungService service =
                new KrankschreibungService(repository);

        Krankschreibung ergebnis = service.krankschreibungAusstellen(
                1L,
                10L,
                20L,
                LocalDate.of(2026, 11, 9),
                LocalDate.of(2026, 11, 13),
                "Grippe"
        );

        assertNotNull(ergebnis);
        assertEquals(1L, ergebnis.id());
        assertTrue(repository.findeNachId(1L).isPresent());
    }
}
