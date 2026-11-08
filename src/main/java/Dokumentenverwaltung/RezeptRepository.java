package Dokumentenverwaltung;

import java.util.List;
import java.util.Optional;

public interface RezeptRepository {

    void speichern(Rezept rezept);

    Optional<Rezept> findeNachId(Long id);

    List<Rezept> findeAlle();
}

