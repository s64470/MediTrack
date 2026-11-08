package Dokumentenverwaltung;

import java.time.LocalDate;

public class UeberweisungService {

    private final UeberweisungRepository repository;

    public UeberweisungService(UeberweisungRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException(
                    "Repository darf nicht null sein"
            );
        }

        this.repository = repository;
    }

    public Ueberweisung ueberweisungAusstellen(
            Long id,
            Long patientId,
            Long arztId,
            String fachrichtung,
            LocalDate ausstellungsDatum,
            String begruendung
    ) {
        Ueberweisung ueberweisung = new Ueberweisung(
                id,
                patientId,
                arztId,
                fachrichtung,
                ausstellungsDatum,
                begruendung
        );

        repository.speichern(ueberweisung);

        return ueberweisung;
    }
}
