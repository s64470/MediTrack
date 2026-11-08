package Dokumentenverwaltung;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UeberweisungServiceTest {

    @Test
    void ueberweisungAusstellenUndSpeichern() {
        InMemoryUeberweisungRepository repository =
                new InMemoryUeberweisungRepository();

        UeberweisungService service =
                new UeberweisungService(repository);

        Ueberweisung ueberweisung = service.ueberweisungAusstellen(
                1L,
                10L,
                20L,
                "Orthopädie",
                LocalDate.of(2026, 11, 9),
                "Untersuchung des Knies"
        );

        assertNotNull(ueberweisung);
        assertEquals(1L, ueberweisung.id());

        assertTrue(
                repository.findeNachId(1L).isPresent()
        );

        assertEquals(
                ueberweisung,
                repository.findeNachId(1L).orElseThrow()
        );
    }
}