package Dokumentenverwaltung;

import java.time.LocalDate;

public record Krankschreibung(
        Long id,
        Long patientId,
        Long arztId,
        LocalDate startDatum,
        LocalDate endDatum,
        String begruendung
) {

    public Krankschreibung {
        if (id == null) {
            throw new IllegalArgumentException("ID darf nicht null sein");
        }

        if (patientId == null) {
            throw new IllegalArgumentException("Patienten-ID darf nicht null sein");
        }

        if (arztId == null) {
            throw new IllegalArgumentException("Arzt-ID darf nicht null sein");
        }

        if (startDatum == null || endDatum == null) {
            throw new IllegalArgumentException(
                    "Start- und Enddatum dürfen nicht null sein"
            );
        }

        if (endDatum.isBefore(startDatum)) {
            throw new IllegalArgumentException(
                    "Enddatum darf nicht vor dem Startdatum liegen"
            );
        }

        if (begruendung == null || begruendung.isBlank()) {
            throw new IllegalArgumentException(
                    "Begründung darf nicht leer sein"
            );
        }
    }

    // Getter zur Kompatibilität mit den bisherigen JUnit-Tests
    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getArztId() {
        return arztId;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public LocalDate getEndDatum() {
        return endDatum;
    }

    public String getBegruendung() {
        return begruendung;
    }
}

