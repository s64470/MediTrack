package com.meditrack.behandlungsmanagement;

import java.time.LocalDate;

public record BehandlungDokumentiert(
        int behandlungId,
        int patientId,
        LocalDate datum
) {

    public BehandlungDokumentiert {
        if (datum == null) {
            throw new IllegalArgumentException(
                    "Das Behandlungsdatum darf nicht fehlen."
            );
        }
    }
}