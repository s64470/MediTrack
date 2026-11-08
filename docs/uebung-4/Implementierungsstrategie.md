# 1. Ausgangslage: Ihre Implementierungsstrategie aus Übung 3
Die Strategie aus dem Dokument `6. Implementierungsstrategie.pdf` sieht eine schrittweise Umsetzung des DDD-Modells von MediTrack in Java vor, mit Maven als Build-Tool und JUnit für automatisierte Tests. Die Anwendung wird in drei Bounded Contexts unterteilt:

| Bounded Context | Verantwortlichkeit |
|---|---|
| `Patientenverwaltung` | Registrierung, Verwaltung und Aktualisierung von Personendaten |
| `Terminverwaltung` | Buchung, Verwaltung und Stornierung von Arztterminen |
| `Behandlungsverwaltung` | Dokumentation von Behandlungen, Krankschreibungen und Überweisungen |

Die Strategie betont Modularität, Testbarkeit und die Trennung von fachlicher Logik und technischen Belangen (z. B. Repositories). Das geplante Vorgehen umfasst fünf Schritte: Java-Klassen erstellen, fachliche Attribute/Methoden implementieren, Repositories und Domain Services definieren, Unit-Tests ergänzen und die Kontexte schrittweise verbinden.
