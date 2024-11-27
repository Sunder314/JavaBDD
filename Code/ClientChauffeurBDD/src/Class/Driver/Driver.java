package Class.Driver;

import Class.User.TypeUser;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Driver {

    private String nom;
    private String prenom;
    private LocalDate date_naissance;
    private TypeDriver type;

    public Driver() {}

    public Driver(String nom, String prenom, LocalDate date_naissance, TypeDriver type) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
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

    public TypeDriver getType() {
        return type;
    }

    public void setType(TypeDriver type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance=" + date_naissance +
                ", type=" + type +
                '}';
    }
}
