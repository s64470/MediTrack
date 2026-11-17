# Method metrics

| Method                                                                                                                    | CogC | ev(G) | iv(G) | v(G) |
|---------------------------------------------------------------------------------------------------------------------------|------|-------|-------|------|
| com.meditrack.behandlungsmanagement.Behandlung.Behandlung(int, int, LocalDate, String, String)                            | 4    | 4     | 2     | 5    |
| com.meditrack.behandlungsmanagement.Behandlung.getBehandlungId()                                                          | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Behandlung.getBeschreibung()                                                          | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Behandlung.getDatum()                                                                 | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Behandlung.getDiagnose()                                                              | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Behandlung.getPatientId()                                                             | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.BehandlungDokumentiert.BehandlungDokumentiert(int, int, LocalDate)                    | 1    | 2     | 1     | 2    |
| com.meditrack.behandlungsmanagement.BehandlungenRepository.alleFinden()                                                   | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.BehandlungenRepository.findenNachId(int)                                              | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.BehandlungenRepository.speichern(Behandlung)                                          | 1    | 2     | 1     | 2    |
| com.meditrack.behandlungsmanagement.BehandlungsService.BehandlungsService(BehandlungenRepository)                         | 1    | 2     | 1     | 2    |
| com.meditrack.behandlungsmanagement.BehandlungsService.behandlungDokumentieren(Behandlung)                                | 1    | 2     | 1     | 2    |
| com.meditrack.behandlungsmanagement.Krankschreibung.Krankschreibung(int, int, LocalDate, LocalDate, String)               | 3    | 3     | 1     | 4    |
| com.meditrack.behandlungsmanagement.Krankschreibung.getBeginn()                                                           | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Krankschreibung.getEnde()                                                             | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Krankschreibung.getGrund()                                                            | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Krankschreibung.getKrankschreibungId()                                                | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Krankschreibung.getPatientId()                                                        | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.KrankschreibungAusgestellt.KrankschreibungAusgestellt(int, int, LocalDate, LocalDate) | 3    | 3     | 1     | 4    |
| com.meditrack.behandlungsmanagement.Ueberweisung.Ueberweisung(int, int, LocalDate, String, String)                        | 3    | 3     | 2     | 4    |
| com.meditrack.behandlungsmanagement.Ueberweisung.getDatum()                                                               | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Ueberweisung.getFachrichtung()                                                        | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Ueberweisung.getGrund()                                                               | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Ueberweisung.getPatientId()                                                           | 0    | 1     | 1     | 1    |
| com.meditrack.behandlungsmanagement.Ueberweisung.getUeberweisungId()                                                      | 0    | 1     | 1     | 1    |
| com.meditrack.patientenverwaltung.Patient.Patient(int, String, String, String, String, String)                            | 4    | 3     | 3     | 5    |
| com.meditrack.patientenverwaltung.Patient.emailValidieren(String)                                                         | 2    | 2     | 2     | 3    |
| com.meditrack.patientenverwaltung.Patient.getAdresse()                                                                    | 0    | 1     | 1     | 1    |
| com.meditrack.patientenverwaltung.Patient.getEmail()                                                                      | 0    | 1     | 1     | 1    |
| com.meditrack.patientenverwaltung.Patient.getNachname()                                                                   | 0    | 1     | 1     | 1    |
| com.meditrack.patientenverwaltung.Patient.getPatientId()                                                                  | 0    | 1     | 1     | 1    |
| com.meditrack.patientenverwaltung.Patient.getTelefonnummer()                                                              | 0    | 1     | 1     | 1    |
| com.meditrack.patientenverwaltung.Patient.getVorname()                                                                    | 0    | 1     | 1     | 1    |
| com.meditrack.patientenverwaltung.Patient.patientendatenAktualisieren(String, String, String)                             | 0    | 1     | 1     | 1    |
| com.meditrack.patientenverwaltung.Patient.telefonnummerValidieren(String)                                                 | 2    | 2     | 2     | 3    |
| com.meditrack.patientenverwaltung.PatientenRepository.speichern(Patient)                                                  | 2    | 3     | 1     | 3    |
| com.meditrack.patientenverwaltung.PatientenRepository.suchenNachId(int)                                                   | 0    | 1     | 1     | 1    |

# Class metrics

| Class                                                          | OCavg | OCmax | WMC |
|----------------------------------------------------------------|-------|-------|-----|
| com.meditrack.behandlungsmanagement.Behandlung                 | 1,50  | 4     | 9   |
| com.meditrack.behandlungsmanagement.BehandlungDokumentiert     | 2,00  | 2     | 2   |
| com.meditrack.behandlungsmanagement.BehandlungenRepository     | 1,33  | 2     | 4   |
| com.meditrack.behandlungsmanagement.BehandlungsService         | 2,00  | 2     | 4   |
| com.meditrack.behandlungsmanagement.Krankschreibung            | 1,33  | 3     | 8   |
| com.meditrack.behandlungsmanagement.KrankschreibungAusgestellt | 3,00  | 3     | 3   |
| com.meditrack.behandlungsmanagement.Ueberweisung               | 1,33  | 3     | 8   |
| com.meditrack.patientenverwaltung.Patient                      | 1,40  | 3     | 14  |
| com.meditrack.patientenverwaltung.PatientKontakt               | n/a   | n/a   | 0   |
| com.meditrack.patientenverwaltung.PatientenRepository          | 2,00  | 3     | 4   |

# Package metrics

| Package                             | v(G)avg | v(G)tot |
|-------------------------------------|---------|---------|
| com.meditrack.behandlungsmanagement | 1,68    | 42      |
| com.meditrack.patientenverwaltung   | 1,83    | 22      |

# Module metrics

| Module    | v(G)avg | v(G)tot |
|-----------|---------|---------|
| meditrack | 1,73    | 64      |

# Project metrics

| Project | v(G)avg | v(G)tot |
|---------|---------|---------|
| project | 1,73    | 64      |