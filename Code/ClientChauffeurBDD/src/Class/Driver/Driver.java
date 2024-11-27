package Class.Driver;

import Class.User.TypeUser;

import java.time.LocalDate;

public class Driver {

    private String nom;
    private String prenom;
    private LocalDate date_naissance;
    private LocalDate date_inscription;
    private TypeDriver type;

    public Driver() {}
    public Driver(String nom, String prenom, LocalDate date_naissance, LocalDate date_inscription, TypeDriver type) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.date_inscription = date_inscription;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public LocalDate getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(LocalDate date_inscription) {
        this.date_inscription = date_inscription;
    }

    public TypeDriver getType() {
        return type;
    }

    public void setType(TypeDriver type) {
        this.type = type;
    }
}
