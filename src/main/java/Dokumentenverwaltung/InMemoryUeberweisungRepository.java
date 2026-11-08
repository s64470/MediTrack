package Dokumentenverwaltung;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryUeberweisungRepository
        implements UeberweisungRepository {

    private final Map<Long, Ueberweisung> ueberweisungen =
            new HashMap<>();

    @Override
    public void speichern(Ueberweisung ueberweisung) {
        if (ueberweisung == null) {
            throw new IllegalArgumentException(
                    "Überweisung darf nicht null sein"
            );
        }

        if (ueberweisungen.containsKey(ueberweisung.id())) {
            throw new IllegalArgumentException(
                    "Eine Überweisung mit dieser ID existiert bereits"
            );
        }

        ueberweisungen.put(
                ueberweisung.id(),
                ueberweisung
        );
    }

    @Override
    public Optional<Ueberweisung> findeNachId(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(ueberweisungen.get(id));
    }

    @Override
    public List<Ueberweisung> findeAlle() {
        return ueberweisungen.values()
                .stream()
                .toList();
    }
}
