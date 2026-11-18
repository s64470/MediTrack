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
TH Lübeck

### Studiengang

Master Medieninformatik (online)

### Dozent/in

Prof. Dr. S. Ipek-Ugay

### Abgabedatum

TT.MM.JJJJ

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















Ab hier löschen!!!!
Aufgabenstellung:
Chronologische Projektentwicklung
Repository Setup und Grundlagen
- Repository: [Link zum Repo]; ggf. Konfigura?on sowie wich?ge Entscheidungen zur Architektur
  CI/(CD-)ImplementaAon
- Pipeline-Au[au: [Kernaspekte der CI-Struktur], Automa?sierungsprozesse (Screenshot der Pipeline-Konfig.)
  Domain-Modellierung und Event-Struktur
- Iden?fizierte (+für das Projekt selek?erte) Domain Events:
1. [Event 1]: [Bedeutung und Kontext]
2. [Event 2]: [Bedeutung und Kontext]
3. [Weitere priorisierte Events...]
- DDD-Structure: Bounded Contexts, Aggregate Roots etc. [Visualisierung Ihrer Domain-Struktur]
  Projekt-ImplemenAerung
- Projektstruktur: [IDE-Screenshot mit Projektstruktur]
- Teststrategie: TDD-Ansatz; Testabdeckung kri?scher Komponenten; Ihr Vorgehen
- Zum Backend und UI/UX
- Backend-Architektur: Kernkomponenten und deren Zusammenspiel, implemen?erte Services,
  Datenmodell (inMemory / SQLite/.?) usw.
- UI-Komponenten:
  o Nutzerinterak?onsfluss [Screenshots der Hauptmasken]
  o Technische Besonderheiten: …
  o [Spezifische Implemen?erungsdetails]
  o [Op?mierungen]
  LLM-IntegraAon
- Einsatzbereiche: Testgenerierung? Code-Op?mierung? [Weitere LLM-Anwendungen]
- Konkrete Beispiele des Mehrwerts
  Technische Herausforderungen
- [Herausforderung 1]: [Lösungsansatz]
- [Herausforderung 2]: [Lösungsansatz]
Projektabschluss
- Erreichte Meilensteine
- Konnten alle priorisierten Events implemen?ert werden?
- Welche Meilensteine konnten nicht erreicht werden?
- Technische Innova?onen
- Lessons Learned und Reflexion
  Hinweise zur Dokumenta4on:
- Gesamtumfang: ca. 4-5 Seiten, Priorisierung der relevantesten Aspekte je nach Projekt, Erwähnung
  eingesetzter Technologien und Darstellung der (technischen und LLM basierenden) Erfahrungen
- Abgabe der Dokumenta?on: via Moodle, vor der finalen Präsenta?on