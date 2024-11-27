package Class.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

    private String nom;
    private String prenom;
    private LocalDate date_naissance;
    private TypeUser type;

    public User(){}

    public User(String nom, String prenom, LocalDate date_naissance, TypeUser type) {
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

    public TypeUser getType() {
        return type;
    }

    public void setType(TypeUser type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance=" + date_naissance +
                ", type=" + type +
                '}';
    }
}
