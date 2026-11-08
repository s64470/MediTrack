package com.meditrack.behandlungsmanagement;

import java.time.LocalDate;

public record KrankschreibungAusgestellt(
        int krankschreibungId,
        int patientId,
        LocalDate beginn,
        LocalDate ende
) {

    public KrankschreibungAusgestellt {
        if (beginn == null || ende == null) {
            throw new IllegalArgumentException(
                    "Beginn und Ende müssen angegeben werden."
            );
        }

        if (ende.isBefore(beginn)) {
            throw new IllegalArgumentException(
                    "Das Ende darf nicht vor dem Beginn liegen."
            );
        }
    }
}