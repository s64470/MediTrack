# 1. Ausgangslage: Ihre Implementierungsstrategie aus Übung 3
Die Strategie aus dem Dokument `6. Implementierungsstrategie.pdf` sieht eine schrittweise Umsetzung des DDD-Modells von MediTrack in Java vor, mit Maven als Build-Tool und JUnit für automatisierte Tests. Die Anwendung wird in drei Bounded Contexts unterteilt:

| Bounded Context | Kernverantwortung | Zentrale Entitäten / Aggregate |
|---|---|---|
| **Patientenverwaltung** | Stammdaten, Registrierung, Aktualisierung | `Patient` (Aggregate Root), `Versicherungsnummer` (Value Object), `Adresse` |
| **Terminverwaltung** | Buchung, Verschiebung, Stornierung | `Termin` (Aggregate Root), `Arzt`, `Zeitfenster` |
| **Behandlungsverwaltung** | Dokumentation, Diagnosen, Krankschreibung | `Behandlung` (Aggregate Root), `Diagnose`, `Krankschreibung` |

Patientenverwaltung	Stammdaten, Registrierung, Aktualisierung	Patient (Aggregate Root), Versicherungsnummer (Value Object), Adresse
Terminverwaltung	Buchung, Verschiebung, Stornierung	Termin (Aggregate Root), Arzt, Zeitfenster
Behandlungsverwaltung	Dokumentation, Diagnosen, Krankschreibung	Behandlung (Aggregate Root), Diagnose, Krankschreibung

Die geplante Umsetzung erfolgt in fünf Schritten:
1. Java-Klassen anlegen,
2. fachliche Attribute/Methoden implementieren,
3. Repositories und Domain Services definieren,
4. Unit-Tests ergänzen,
5. Kontexte schrittweise verbinden.

Die Strategie betont Modularität, Testbarkeit und die Trennung von Domänenlogik und technischen Belangen.
