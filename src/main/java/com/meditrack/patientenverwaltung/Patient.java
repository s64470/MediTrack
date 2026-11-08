
package com.meditrack.patientenverwaltung;

public class Patient {

    private int patientId;
    private String vorname;
    private String nachname;
    private String adresse;
    private String telefonnummer;
    private String email;

    public Patient(int patientId, String vorname, String nachname,
                   String adresse, String telefonnummer, String email) {

        if (vorname == null || vorname.isBlank()) {
            throw new IllegalArgumentException("Vorname darf nicht leer sein.");
        }

        if (nachname == null || nachname.isBlank()) {
            throw new IllegalArgumentException("Nachname darf nicht leer sein.");
        }

        emailValidieren(email);
        telefonnummerValidieren(telefonnummer);

        this.patientId = patientId;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.email = email;
    }
    public int getPatientId() {
        return patientId;
    }
    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void patientendatenAktualisieren(
            String adresse, String telefonnummer, String email) {

        emailValidieren(email);
        telefonnummerValidieren(telefonnummer);

        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.email = email;
    }

    private static void emailValidieren(String email) {
        if (email == null || !email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("E-Mail-Adresse ist ungültig.");
        }
    }

    private static void telefonnummerValidieren(String telefonnummer) {
        if (telefonnummer == null || !telefonnummer.matches("\\+?[0-9]{6,15}")) {
            throw new IllegalArgumentException("Telefonnummer ist ungültig.");
        }
    }
}
