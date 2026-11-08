package Dokumentenverwaltung;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryKrankschreibungRepository
        implements KrankschreibungRepository {

    private final Map<Long, Krankschreibung> krankschreibungen =
            new HashMap<>();

    @Override
    public void speichern(Krankschreibung krankschreibung) {
        if (krankschreibung == null) {
            throw new IllegalArgumentException(
                    "Krankschreibung darf nicht null sein"
            );
        }

        if (krankschreibungen.containsKey(krankschreibung.id())) {
            throw new IllegalArgumentException(
                    "Eine Krankschreibung mit dieser ID existiert bereits"
            );
        }

        krankschreibungen.put(
                krankschreibung.id(),
                krankschreibung
        );
    }

    @Override
    public Optional<Krankschreibung> findeNachId(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(krankschreibungen.get(id));
    }

    @Override
    public List<Krankschreibung> findeAlle() {
        return krankschreibungen.values()
                .stream()
                .toList();
    }
}
