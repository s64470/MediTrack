package Terminmanagement;

import java.util.ArrayList;
import java.util.List;

public class TerminRepository {

    private final List<Termin> termine = new ArrayList<>();

    public void speichern(Termin termin) {
        if (termin == null) {
            throw new IllegalArgumentException(
                    "Termin darf nicht null sein"
            );
        }

        boolean idExistiertBereits = termine.stream()
                .anyMatch(
                        vorhandenerTermin ->
                                vorhandenerTermin.getId().equals(termin.getId())
                );

        if (idExistiertBereits) {
            throw new IllegalArgumentException(
                    "Ein Termin mit dieser ID existiert bereits"
            );
        }

        termine.add(termin);
    }

    public List<Termin> findeAlle() {
        return new ArrayList<>(termine);
    }
}
