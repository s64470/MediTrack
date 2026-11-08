package com.meditrack.behandlungsmanagement;

public class BehandlungsService {

    private final BehandlungenRepository repository;

    public BehandlungsService(BehandlungenRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException(
                    "Repository darf nicht fehlen."
            );
        }

        this.repository = repository;
    }

    public BehandlungDokumentiert behandlungDokumentieren(
            Behandlung behandlung) {

        if (behandlung == null) {
            throw new IllegalArgumentException(
                    "Behandlung darf nicht fehlen."
            );
        }

        repository.speichern(behandlung);

        return new BehandlungDokumentiert(
                behandlung.getBehandlungId(),
                behandlung.getPatientId(),
                behandlung.getDatum()
        );
    }
}