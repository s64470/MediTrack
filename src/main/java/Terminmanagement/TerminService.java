package Terminmanagement;

public class TerminService {

    private final TerminRepository repository;

    public TerminService(TerminRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException(
                    "Repository darf nicht null sein"
            );
        }

        this.repository = repository;
    }

    public void terminBuchen(Termin termin) {
        if (termin == null) {
            throw new IllegalArgumentException(
                    "Termin darf nicht null sein"
            );
        }

        repository.speichern(termin);
    }

    public void terminStornieren(Termin termin) {
        if (termin == null) {
            throw new IllegalArgumentException(
                    "Termin darf nicht null sein"
            );
        }

        termin.stornieren();
    }
}