# Git-Handout für Anfänger
## Übung 1 – Moderne Softwareentwicklung
Dieses Handout vermittelt die wichtigsten Grundlagen von Git und erläutert typische Arbeitsabläufe bei der Versionsverwaltung. Ziel ist es, den Umgang mit Git sowie die Zusammenarbeit im Team über die Plattform wie GitHub kennenzulernen.

---
# Was ist Git und warum sollte es verwendet werden?
Git ist ein verteiltes Versionskontrollsystem, das Änderungen an Dateien und Projekten dokumentiert. Es ermöglicht mehreren Personen, gleichzeitig an einem Projekt zu arbeiten und dabei alle Änderungen nachvollziehbar zu speichern.

## Vorteile von Git
- Nachverfolgung aller Änderungen
- Zusammenarbeit im Team
- Wiederherstellung älterer Versionen
- Paralleles Arbeiten durch Branches
- Sichere Verwaltung von Projektständen
- Integration mit Plattformen wie GitHub oder GitLab
---

# Grundlegende Git-Befehle
## Repository initialisieren
```bash
git init
```
Erstellt ein neues lokales Git-Repository.

## Repository klonen
```bash
git clone <repository-url>
```
Lädt ein bestehendes Repository auf den lokalen Rechner.

## Dateien zur Staging Area hinzufügen
```bash
git add README.md
```
Fügt eine bestimmte Datei hinzu.
```bash
git add .
```
Fügt alle geänderten Dateien hinzu.

## Änderungen speichern
```bash
git commit -m "Beschreibung der Änderung"
```
Erstellt einen Commit und speichert die Änderungen in der Versionshistorie.

## Änderungen hochladen
```bash
git push origin main
```
Überträgt lokale Änderungen in das Remote-Repository.

## Änderungen herunterladen
```bash
git pull origin main
```
Aktualisiert das lokale Repository mit den neuesten Änderungen.

## Status anzeigen
```bash
git status
```
Zeigt den aktuellen Zustand des Repositories an.
