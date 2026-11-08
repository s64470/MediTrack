package com.meditrack.behandlungsmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BehandlungenRepository {

    private final List<Behandlung> behandlungen = new ArrayList<>();

    public void speichern(Behandlung behandlung) {
        if (behandlung == null) {
            throw new IllegalArgumentException(
                    "Behandlung darf nicht null sein."
            );
        }

        behandlungen.add(behandlung);
    }

    public Optional<Behandlung> findenNachId(int behandlungId) {
        return behandlungen.stream()
                .filter(behandlung ->
                        behandlung.getBehandlungId() == behandlungId)
                .findFirst();
    }

    public List<Behandlung> alleFinden() {
        return new ArrayList<>(behandlungen);
    }
}