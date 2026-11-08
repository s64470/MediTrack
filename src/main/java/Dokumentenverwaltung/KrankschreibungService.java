package Dokumentenverwaltung;

import java.time.LocalDate;

public class KrankschreibungService {

    private final KrankschreibungRepository repository;

    public KrankschreibungService(KrankschreibungRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException(
                    "Repository darf nicht null sein"
            );
        }

        this.repository = repository;
    }

    public Krankschreibung krankschreibungAusstellen(
            Long id,
            Long patientId,
            Long arztId,
            LocalDate startDatum,
            LocalDate endDatum,
            String begruendung
    ) {
        Krankschreibung krankschreibung = new Krankschreibung(
                id,
                patientId,
                arztId,
                startDatum,
                endDatum,
                begruendung
        );

        repository.speichern(krankschreibung);

        return krankschreibung;
    }
}