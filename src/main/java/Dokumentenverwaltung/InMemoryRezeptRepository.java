package Dokumentenverwaltung;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryRezeptRepository
        implements RezeptRepository {

    private final Map<Long, Rezept> rezepte = new HashMap<>();

    @Override
    public void speichern(Rezept rezept) {
        if (rezept == null) {
            throw new IllegalArgumentException(
                    "Rezept darf nicht null sein"
            );
        }

        if (rezepte.containsKey(rezept.id())) {
            throw new IllegalArgumentException(
                    "Ein Rezept mit dieser ID existiert bereits"
            );
        }

        rezepte.put(
                rezept.id(),
                rezept
        );
    }

    @Override
    public Optional<Rezept> findeNachId(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(rezepte.get(id));
    }

    @Override
    public List<Rezept> findeAlle() {
        return rezepte.values()
                .stream()
                .toList();
    }
}
