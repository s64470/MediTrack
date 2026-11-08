package Dokumentenverwaltung;

import java.time.LocalDate;

public record Ueberweisung(
        Long id,
        Long patientId,
        Long arztId,
        String fachrichtung,
        LocalDate ausstellungsDatum,
        String begruendung
) {

    public Ueberweisung {
        if (id == null) {
            throw new IllegalArgumentException(
                    "ID darf nicht null sein"
            );
        }

        if (patientId == null) {
            throw new IllegalArgumentException(
                    "Patienten-ID darf nicht null sein"
            );
        }

        if (arztId == null) {
            throw new IllegalArgumentException(
                    "Arzt-ID darf nicht null sein"
            );
        }

        if (fachrichtung == null || fachrichtung.isBlank()) {
            throw new IllegalArgumentException(
                    "Fachrichtung darf nicht leer sein"
            );
        }

        if (ausstellungsDatum == null) {
            throw new IllegalArgumentException(
                    "Ausstellungsdatum darf nicht null sein"
            );
        }

        if (begruendung == null || begruendung.isBlank()) {
            throw new IllegalArgumentException(
                    "Begründung darf nicht leer sein"
            );
        }
    }
}
