# MediTrack

Finale Dokumentation der semesterbegleitenden Projektarbeit - Team 4

## Teammitglieder

| Name                      |
|---------------------------|
| Daniel Riel               |
| Lara Spies                |
| Thijambaki Kirushnathasan |

### Modul

Moderne Softwareentwicklung

### Hochschule

BHT - Berliner Hochschule für Technik <br>
TH Lübeck - Technische Hochschule Lübeck

### Studiengang

Master Medieninformatik (online)

### Dozent/in

Prof. Dr. Selcan Ipek-Ugay

### Abgabedatum

TT.MM.2027

## Projektthema

MediTrack ist ein System zur Verwaltung und Überwachung von Patientendaten im Gesundheitswesen. Die Anwendung ermöglicht die Erfassung und Verwaltung von Patienteninformationen, Vitaldaten sowie Behandlungshistorien. Durch die kontinuierliche Überwachung kritischer Gesundheitswerte werden automatische Benachrichtigungen ausgelöst, um medizinisches Personal frühzeitig auf potenzielle Risiken aufmerksam zu machen und eine schnelle Reaktion zu ermöglichen.

## Einführung und Kontext
### Motivation
Die fortschreitende Digitalisierung im Gesundheitswesen erfordert leistungsfähige Systeme zur effizienten Verwaltung und Überwachung von Patientendaten. MediTrack wurde entwickelt, um medizinisches Personal durch die zentrale Erfassung von Patienteninformationen und die automatische Überwachung kritischer Gesundheitswerte zu unterstützen, sodass Risiken frühzeitig erkannt und die Patientensicherheit verbessert werden können.

## Zielsetzung
Ziel dieser Arbeit ist die Konzeption und Entwicklung des Systems `MediTrack` zur digitalen Verwaltung und Überwachung von Patientendaten im Gesundheitswesen. Dabei soll eine Anwendung geschaffen werden, die eine strukturierte Erfassung, Speicherung und Verwaltung von Patienteninformationen, Vitaldaten sowie Behandlungshistorien ermöglicht. Darüber hinaus wird ein Mechanismus zur kontinuierlichen Überwachung kritischer Gesundheitsparameter implementiert, um potenzielle gesundheitliche Risiken frühzeitig zu identifizieren. Durch die automatische Generierung von Benachrichtigungen bei auffälligen Messwerten soll das medizinische Personal in die Lage versetzt werden, zeitnah auf kritische Situationen zu reagieren. Langfristig verfolgt das System das Ziel, die Patientensicherheit zu erhöhen, die Effizienz klinischer Prozesse zu verbessern und die Qualität der medizinischen Versorgung durch den Einsatz digitaler Technologien zu unterstützen.

## Technologie-Stack
Für die Entwicklung von `MediTrack` wird ein Technologie-Stack eingesetzt, der die effiziente Verwaltung und Überwachung von Patientendaten unterstützt. Die Anwendung wurde als digitales Informationssystem konzipiert, das die Erfassung, Speicherung und Verarbeitung von Patienteninformationen, Vitaldaten und Behandlungshistorien ermöglicht. Gleichzeitig bildet die technische Grundlage die kontinuierliche Überwachung gesundheitsrelevanter Parameter sowie die automatische Generierung von Benachrichtigungen bei kritischen Messwerten.

Zur Umsetzung des Systems werden Technologien für die Benutzerschnittstelle, die Geschäftslogik sowie die Datenhaltung eingesetzt. Die Benutzeroberfläche ermöglicht eine strukturierte Darstellung und Verwaltung von Patientendaten, während die Backend-Komponenten für die Verarbeitung von Anfragen, die Verwaltung medizinischer Informationen und die Überwachung von Vitalparametern verantwortlich sind. Die Datenspeicherung erfolgt über eine zentrale Datenhaltung, wodurch eine konsistente und sichere Verwaltung der Patientendaten gewährleistet wird.

Für die Versionsverwaltung kommt Git zum Einsatz. Die Quellcodeverwaltung sowie die Dokumentation des Projekts erfolgen über die Plattform GitHub, wodurch Änderungen nachvollziehbar dokumentiert und eine kollaborative Softwareentwicklung unterstützt werden. Darüber hinaus ermöglicht die modulare Architektur von `MediTrack` eine einfache Erweiterung des Systems um zusätzliche Funktionen und zukünftige Integrationen im Gesundheitswesen.

### Eingesetzte Technologien
- Git – Versionsverwaltung des Quellcodes
- GitHub – Repository- und Projektverwaltung
- Datenbanksystem – Speicherung von Patienten-, Behandlungs- und Vitaldaten
- Backend-Technologien – Verwaltung der Geschäftslogik und Überwachung von Gesundheitsdaten
- Frontend-Technologien – Benutzeroberfläche zur Verwaltung und Visualisierung von Patientendaten
- Benachrichtigungssystem – Automatische Warnungen bei kritischen Gesundheitswerten

## Chronologische Projektentwicklung
Der vollständige Quellcode des Projekts sowie die Versionshistorie sind im GitHub-Repository MediTrack verfügbar: https://github.com/s64470/MediTrack

### CI/(CD-)Implementation/Pipeline Aufbau
Die CI-Pipeline wird automatisch ausgeführt, sobald Änderungen per `Push` auf den `main-Branch` übertragen oder ein `Pull Request` gegen den `main-Branch` erstellt wird. Dadurch wird sichergestellt, dass neuer Code vor der Integration automatisch geprüft wird. 

Zunächst wird der aktuelle Quellcode aus dem GitHub-Repository ausgecheckt. Anschließend überprüft die Pipeline, ob ein Maven-Projekt vorliegt, indem nach den notwendigen Maven-Konfigurationsdateien gesucht wird. Wird ein Maven-Projekt erkannt, richtet GitHub Actions eine Java-21-Umgebung (Temurin Distribution) ein und aktiviert einen Maven-Cache, um Build-Zeiten zu verkürzen.

Im nächsten Schritt wird das Projekt mit dem Befehl `mvn clean verify` gebaut und getestet. Dabei werden sowohl die Anwendung kompiliert als auch alle vorhandenen automatisierten Tests ausgeführt. Schlägt einer dieser Schritte fehl, wird die Pipeline abgebrochen.

Nach erfolgreichem Build werden die erzeugten `JAR-Artefakte` aus dem target-Verzeichnis hochgeladen und für 14 Tage gespeichert. Diese Artefakte können anschließend heruntergeladen oder in weiteren Deployment-Schritten verwendet werden.

Ablauf der Pipeline:
- Push oder Pull Request auf main
- Quellcode aus Repository laden
- Maven-Projekt erkennen
- Java 21 und Maven-Cache konfigurieren
- Projekt bauen und Tests ausführen (`mvn clean verify`)
- Erzeugte JAR-Datei als Artefakt speichern

Da die Pipeline derzeit nur den Build-, Test- und Artefakt-Upload-Prozess umfasst, handelt es sich streng genommen um eine Continuous Integration (CI)-Pipeline. Ein automatisches Deployment (CD) ist im gezeigten Workflow noch nicht implementiert.















[//]: # (Ab hier löschen!!!! <br>)

[//]: # (Aufgabenstellung:)

[//]: # (Chronologische Projektentwicklung)

[//]: # (Repository Setup und Grundlagen)

[//]: # (- Repository: [Link zum Repo]; ggf. Konfigura?on sowie wich?ge Entscheidungen zur Architektur)

[//]: # (  CI/&#40;CD-&#41;ImplementaAon)

[//]: # (- Pipeline-Au[au: [Kernaspekte der CI-Struktur], Automa?sierungsprozesse &#40;Screenshot der Pipeline-Konfig.&#41;)

[//]: # (  Domain-Modellierung und Event-Struktur)

[//]: # (- Iden?fizierte &#40;+für das Projekt selek?erte&#41; Domain Events:)

[//]: # (1. [Event 1]: [Bedeutung und Kontext])

[//]: # (2. [Event 2]: [Bedeutung und Kontext])

[//]: # (3. [Weitere priorisierte Events...])

[//]: # (- DDD-Structure: Bounded Contexts, Aggregate Roots etc. [Visualisierung Ihrer Domain-Struktur])

[//]: # (  Projekt-ImplemenAerung)

[//]: # (- Projektstruktur: [IDE-Screenshot mit Projektstruktur])

[//]: # (- Teststrategie: TDD-Ansatz; Testabdeckung kri?scher Komponenten; Ihr Vorgehen)

[//]: # (- Zum Backend und UI/UX)

[//]: # (- Backend-Architektur: Kernkomponenten und deren Zusammenspiel, implemen?erte Services,)

[//]: # (  Datenmodell &#40;inMemory / SQLite/.?&#41; usw.)

[//]: # (- UI-Komponenten:)

[//]: # (  o Nutzerinterak?onsfluss [Screenshots der Hauptmasken])

[//]: # (  o Technische Besonderheiten: …)

[//]: # (  o [Spezifische Implemen?erungsdetails])

[//]: # (  o [Op?mierungen])

[//]: # (  LLM-IntegraAon)

[//]: # (- Einsatzbereiche: Testgenerierung? Code-Op?mierung? [Weitere LLM-Anwendungen])

[//]: # (- Konkrete Beispiele des Mehrwerts)

[//]: # (  Technische Herausforderungen)

[//]: # (- [Herausforderung 1]: [Lösungsansatz])

[//]: # (- [Herausforderung 2]: [Lösungsansatz])

[//]: # (Projektabschluss)

[//]: # (- Erreichte Meilensteine)

[//]: # (- Konnten alle priorisierten Events implemen?ert werden?)

[//]: # (- Welche Meilensteine konnten nicht erreicht werden?)

[//]: # (- Technische Innova?onen)

[//]: # (- Lessons Learned und Reflexion)

[//]: # (  Hinweise zur Dokumenta4on:)

[//]: # (- Gesamtumfang: ca. 4-5 Seiten, Priorisierung der relevantesten Aspekte je nach Projekt, Erwähnung)

[//]: # (  eingesetzter Technologien und Darstellung der &#40;technischen und LLM basierenden&#41; Erfahrungen)

[//]: # (- Abgabe der Dokumenta?on: via Moodle, vor der finalen Präsenta?on)