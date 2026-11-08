package Terminmanagement;
import java.time.LocalDateTime;

public class Termin {

    private Long id;
    private Long patientId;
    private Long arztId;
    private LocalDateTime datumUhrzeit;
    private String beschreibung;
    private TerminStatus status;

    public Termin(Long id, Long patientId, Long arztId,
                  LocalDateTime datumUhrzeit,
                  String beschreibung) {

        if (patientId == null) {
            throw new IllegalArgumentException("Patient-ID darf nicht fehlen");
        }

        if (arztId == null) {
            throw new IllegalArgumentException("Arzt-ID darf nicht fehlen");
        }

        if (datumUhrzeit == null) {
            throw new IllegalArgumentException("Termin-Datum darf nicht fehlen");
        }

        if (!datumUhrzeit.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "Termin darf nicht in der Vergangenheit liegen");
        }

        if (id == null) {
            throw new IllegalArgumentException("Termin-ID darf nicht fehlen");
        }

        this.id = id;
        this.patientId = patientId;
        this.arztId = arztId;
        this.datumUhrzeit = datumUhrzeit;
        this.beschreibung = beschreibung;
        this.status = TerminStatus.GEBUCHT;
    }

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getArztId() {
        return arztId;
    }

    public LocalDateTime getDatumUhrzeit() {
        return datumUhrzeit;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public TerminStatus getStatus() {
        return status;
    }

    public void stornieren() {
        this.status = TerminStatus.STORNIERT;
    }
}