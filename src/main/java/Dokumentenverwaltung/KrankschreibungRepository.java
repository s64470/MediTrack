package Dokumentenverwaltung;

import java.util.List;
import java.util.Optional;

public interface KrankschreibungRepository {

    void speichern(Krankschreibung krankschreibung);

    Optional<Krankschreibung> findeNachId(Long id);

    List<Krankschreibung> findeAlle();
}
