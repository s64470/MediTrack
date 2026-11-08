# 1. Ausgangslage: Implementierungsstrategie aus Übung 3 (Zusammenfassung)
Die Strategie aus dem Dokument `6. Implementierungsstrategie.pdf` sieht eine schrittweise Umsetzung des DDD-Modells von MediTrack in Java vor, mit Maven als Build-Tool und JUnit für automatisierte Tests. Die Anwendung wird in drei Bounded Contexts unterteilt:

| Bounded Context | Kernverantwortung | Zentrale Entitäten / Aggregate |
|---|---|---|
| **Patientenverwaltung** | Stammdaten, Registrierung, Aktualisierung | `Patient` (Aggregate Root), `Versicherungsnummer` (Value Object), `Adresse` |
| **Terminverwaltung** | Buchung, Verschiebung, Stornierung | `Termin` (Aggregate Root), `Arzt`, `Zeitfenster` |
| **Behandlungsverwaltung** | Dokumentation, Diagnosen, Krankschreibung | `Behandlung` (Aggregate Root), `Diagnose`, `Krankschreibung` |

Die geplante Umsetzung erfolgt in fünf Schritten:
1. Java-Klassen anlegen,
2. fachliche Attribute/Methoden implementieren,
3. Repositories und Domain Services definieren,
4. Unit-Tests ergänzen,
5. Kontexte schrittweise verbinden.

Die Strategie betont Modularität, Testbarkeit und die Trennung von Domänenlogik und technischen Belangen.


## 2. Die wichtigsten Domain Events

Ein **Domain Event** dokumentiert fachlich bedeutsame Ereignisse, die den Zustand des Systems verändern und für andere Bounded Contexts relevant sein können. Für MediTrack lassen sich folgende zentrale Events identifizieren.

### Event 1: `PatientRegistriert`

| Eigenschaft | Inhalt |
|---|---|
| **Bounded Context** | Patientenverwaltung |
| **Auslöser** | Anlegen eines neuen `Patient`-Aggregates |
| **Payload (Felder)** | `patientId` (UUID), `vorname`, `nachname`, `geburtsdatum`, `versicherungsnummer`, `registriertAm` (Timestamp) |
| **Fachliche Relevanz** | Macht einen Patienten für die Terminverwaltung buchbar |
| **Konsumenten** | Terminverwaltung, Benachrichtigungsservice |

### Event 2: `TerminGebucht`

| Eigenschaft | Inhalt |
|---|---|
| **Bounded Context** | Terminverwaltung |
| **Auslöser** | Erfolgreiche Reservierung eines Zeitfensters |
| **Payload (Felder)** | `terminId` (UUID), `patientId`, `arztId`, `terminBeginn`, `terminEnde`, `gebuchtAm` |
| **Fachliche Relevanz** | Signalisiert dem Patienten eine Bestätigung; blockiert das Zeitfenster des Arztes |
| **Konsumenten** | Behandlungsverwaltung (Vorbereitung), Benachrichtigungsservice, Abrechnung |

### Ergänzend (optional): `BehandlungDokumentiert`

| Eigenschaft | Inhalt |
|---|---|
| **Bounded Context** | Behandlungsverwaltung |
| **Auslöser** | Erfassung einer abgeschlossenen Behandlung |
| **Payload** | `behandlungId`, `patientId`, `diagnose`, `behandlungsDatum`, `arztId` |
| **Konsumenten** | Abrechnung, Patientenverwaltung (Historie) |
