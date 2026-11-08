package Dokumentenverwaltung;

import java.time.LocalDate;

public record Rezept(
        Long id,
        Long patientId,
        Long arztId,
        String medikament,
        String dosierung,
        LocalDate ausstellungsDatum,
        String anweisungen
) {

    public Rezept {
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

        if (medikament == null || medikament.isBlank()) {
            throw new IllegalArgumentException(
                    "Medikament darf nicht leer sein"
            );
        }

        if (dosierung == null || dosierung.isBlank()) {
            throw new IllegalArgumentException(
                    "Dosierung darf nicht leer sein"
            );
        }

        if (ausstellungsDatum == null) {
            throw new IllegalArgumentException(
                    "Ausstellungsdatum darf nicht null sein"
            );
        }

        if (anweisungen == null || anweisungen.isBlank()) {
            throw new IllegalArgumentException(
                    "Anweisungen dürfen nicht leer sein"
            );
        }
    }
}

