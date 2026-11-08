package Dokumentenverwaltung;

import java.time.LocalDate;

public class RezeptService {

    private final RezeptRepository repository;

    public RezeptService(RezeptRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException(
                    "Repository darf nicht null sein"
            );
        }

        this.repository = repository;
    }

    public Rezept rezeptAusstellen(
            Long id,
            Long patientId,
            Long arztId,
            String medikament,
            String dosierung,
            LocalDate ausstellungsDatum,
            String anweisungen
    ) {
        Rezept rezept = new Rezept(
                id,
                patientId,
                arztId,
                medikament,
                dosierung,
                ausstellungsDatum,
                anweisungen
        );

        repository.speichern(rezept);

        return rezept;
    }
}
