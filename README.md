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

<<<<<<< Updated upstream

# Branches und ihre Nutzung
## Was ist ein Branch?
Ein Branch ist ein Entwicklungszweig im Git. Durch ihn ist es möglich, Änderungen vorzunehmen ohne dabei den Hauptzweig zu beeinflussen. Dadurch ist es ebenso möglich, dass mehrere Personen unabhängig voneinander gleichzeitig an einem Projekt arbeiten können. 

Der Haupt-Branch ist häufig main. Für neue Funktionen oder Änderungen ist es ebenso möglich, zusätzliche Branches zu erstellen. Nach der Bearbeitung können diese Änderungen dann überprüft und im Haupt-Branch übernommen werden. 

## Warum sind Branches sinnvoll?
- Mehrere Personen können gleichzeitig an einem Projekt arbeiten.
- Neue Funktionen können getrennt entwickelt und getestet werden. 
- Änderungen können überprüft werden.

## wichtige Branch-Befehle
1. Vorhandene Branches anzeigen
```bash
git branch
```
Mit diesem Befehl werden alle lokalen Branches angezeigt. 

2. Einen neuen Branch erstellen
```bash
git switch -c feature-branch
```
Mit diesem Befehl kann ein neuer Branch erstellt und anschließend direkt zu diesem gewechselt werden.

3.Zwischen Branches wechseln
```bash
git switch main
```
Dieser Befehl wechselt zum Haupt-Branch.

4.Branches zusammenführen
```bash
git merge feature-branch
```
Mit diesem Befehl können Änderungen eines Branches in den aktuell ausgewählten Branch übernommen werden.

5.Einen Branch löschen
```bash
git branch -d feature-branch
```
Mit diesem Befehl wird ein nicht mehr benötigter Branch lokal gelöscht.


# Umgang mit Merge-Konflikten
## Was ist ein Merge-Konflikt?
Git Änderungen aus verschiedenen Branches können nicht automatisch zusammengeführt werden, z. B. wenn mehrere Personen dieselbe Stelle unterschiedlich bearbeiten. Dadurch entsteht ein Menge-Konflikt. 

Beispiel: 
```text
<<<<<<< HEAD
Alter Inhalt
=======
Neuer Inhalt 
>>>>>>> feature-branch
```

## Konflikt lösen
1. Konflikt im Pull Request erkennen.
2. Änderungen vergleichen.
3. Gewünschte Änderung auswählen.
4. Konfliktmarkierungen entfernen.
5. Änderungen speichern.
6. Ergebnis überprüfen
7. Merge abschließen.

## Konflikte vermeiden
- Regelmäßig Änderungen synchronisieren.
- Sorgfältige Kommunikation im Team.
- Gleichzeitige Bearbeitungen an derselben Datei vermeiden. 


# Git mit IntelliJ IDEA benutzen
## Was ist IntelliJ IDEA?
IntelliJ IDEA ist eine integrierte Entwicklungsumgebung, die besonders gut für die Programmierung in Java geeignet ist. Sie unterstützt beim Schreiben, Testen und Verwalten von Code.

## Git-Unterstützung in IntelliJ IDEA
IntelliJ IDEA verfügt über integrierte Git-Funktionen, wodurch es möglich ist, Repositories direkt in der Entwicklungsumgebung zu verwalten. 

## zu den wichtigsten Funktionen gehören dabei:
- Änderungen überprüfen: geänderte Dateien werden übersichtlich angezeigt.
- Commits erstellen: Änderungen können mit einer Nachricht gespeichert werden. 
- Branches verwalten: Neue Branches lassen sich erstellen und auswählen.
- Push & Pull: Änderungen können in GitHub hochgeladen werden und von dort aus anschließend heruntergeladen werden. 
- Merge & Konfliktlösung: Änderungen aus verschiedenen Branches können zusammengeführt werden.

## Mit GitHub arbeiten
Ein bestehendes Repository kann in IntelliJ IDEA geklont werden. Dabei lohnt es sich, für eine neue Aufgabe einen neuen Branch zu verwenden und kleine Commits erstellen zu können. 
