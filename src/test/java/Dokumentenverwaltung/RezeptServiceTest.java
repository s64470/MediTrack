package Dokumentenverwaltung;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RezeptServiceTest {

    @Test
    void rezeptAusstellenUndSpeichern() {
        RezeptRepository repository =
                new InMemoryRezeptRepository();

        RezeptService service =
                new RezeptService(repository);

        Rezept rezept = service.rezeptAusstellen(
                1L,
                10L,
                20L,
                "Medikament A",
                "1 Tablette täglich",
                LocalDate.of(2026, 11, 9),
                "Mit ausreichend Wasser einnehmen"
        );

        assertNotNull(rezept);
        assertEquals(1L, rezept.id());

        assertTrue(repository.findeNachId(1L).isPresent());
        assertEquals(
                rezept,
                repository.findeNachId(1L).get()
        );
    }
}
