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

        boolean terminExistiert = repository.findeAlle().stream()
                .anyMatch(
                        gespeicherterTermin ->
                                gespeicherterTermin.getId().equals(termin.getId())
                );

        if (!terminExistiert) {
            throw new IllegalArgumentException(
                    "Der Termin ist nicht im Repository gespeichert"
            );
        }

        termin.stornieren();
    }
}