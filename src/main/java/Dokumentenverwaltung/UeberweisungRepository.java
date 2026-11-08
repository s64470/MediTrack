package Dokumentenverwaltung;

import java.util.List;
import java.util.Optional;

public interface UeberweisungRepository {

    void speichern(Ueberweisung ueberweisung);

    Optional<Ueberweisung> findeNachId(Long id);

    List<Ueberweisung> findeAlle();
}
