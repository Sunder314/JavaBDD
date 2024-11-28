import Class.Course.Course;
import Class.Driver.Driver;
import Class.Driver.TypeDriver;
import Class.User.TypeUser;
import Class.User.User;
import Service.Course.CourseService;
import Service.Driver.DriverService;
import Service.User.UserService;
import connection.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Locale.US;

public class Main {
    public static void main(String[] args) throws SQLException {
        Dao dao = new Dao();
        ResultSet rs;
        String rq;
        User user = new User("Audouy","Julia", LocalDate.parse("2004-09-08"), TypeUser.ETUDIANT);
        UserService us = new UserService();
        Driver driver = new Driver("Gorua","Paula", LocalDate.parse("2007-07-08"), TypeDriver.MOTARD);
        DriverService ds = new DriverService();
        Course course = new Course(1,2, Time.valueOf("00:12:34"),12.3F);
        CourseService cs = new CourseService();
        Float marge = cs.CalculerMarge(LocalDate.parse("2024-11-27"), LocalDate.parse("2024-11-30"));

    }

    public static User GenerateUser() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est votre prenom");
        String prenom = sc.nextLine();
        System.out.println("Quel est votre nom");
        String nom = sc.nextLine();
        System.out.println("Quel est votre jour de naissance");
        int jour = sc.nextInt();
        System.out.println("Quel est votre mois de naissance");
        int mois = sc.nextInt();
        System.out.println("Quel est votre année de naissance");
        int annee = sc.nextInt();
        LocalDate date = LocalDate.of(annee, mois, jour);
        System.out.println("Quel est votre status (etudiant, client, premium)");
        String st = sc.next().toLowerCase(Locale.ROOT);
        TypeUser status;
        switch (st) {
            case "etudiant":
                status = TypeUser.ETUDIANT;
                break;
            case "client":
                status = TypeUser.CLIENT;
                break;
            case "premium":
                status = TypeUser.PREMIUM;
                break;
            default:
                return null;
        }
        User user = new User(nom, prenom, date, status);
        UserService userService = new UserService();
        userService.addUser(user);
        return user;
    }

    public static Driver GenerateDriver() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est votre prenom");
        String prenom = sc.nextLine();
        System.out.println("Quel est votre nom");
        String nom = sc.nextLine();
        System.out.println("Quel est votre jour de naissance");
        int jour = sc.nextInt();
        System.out.println("Quel est votre mois de naissance");
        int mois = sc.nextInt();
        System.out.println("Quel est votre année de naissance");
        int annee = sc.nextInt();
        LocalDate date = LocalDate.of(annee, mois, jour);
        System.out.println("Quel est votre vehicule (motard ou voiture)");
        String st = sc.next().toLowerCase(Locale.ROOT);
        TypeDriver status;
        switch (st) {
            case "motard":
                status = TypeDriver.MOTARD;
                break;
            case "voiture":
                status = TypeDriver.VOITURE;
                break;
            default:
                return null;
        }
        Driver driver = new Driver(nom, prenom, date, status);
        DriverService driverService = new DriverService();
        driverService.addDriver(driver);
        return driver;
    }

    public static Course GenerateCourse() throws SQLException {
        Scanner sc = new Scanner(System.in);

        // Saisie de l'ID utilisateur
        System.out.println("Entrez l'ID de l'utilisateur (id_u) :");
        int id_u = sc.nextInt();

        // Saisie de l'ID du conducteur
        System.out.println("Entrez l'ID du conducteur (idD) :");
        int idD = sc.nextInt();

        // Saisie des heures, minutes et secondes pour le temps de la course
        System.out.println("Entrez les heures de la course :");
        int heures = sc.nextInt();

        System.out.println("Entrez les minutes de la course :");
        int minutes = sc.nextInt();

        System.out.println("Entrez les secondes de la course :");
        int secondes = sc.nextInt();

        // Validation des entrées pour le temps
        if (heures < 0 || minutes < 0 || minutes >= 60 || secondes < 0 || secondes >= 60) {
            System.err.println("Le temps saisi est invalide. La course n'a pas été générée.");
            return null;
        }

        // Création de l'objet Time
        Time tempsTC = Time.valueOf(String.format("%02d:%02d:%02d", heures, minutes, secondes));

        // Saisie de la distance de la course
        System.out.println("Entrez la distance de la course (en km, format décimal) :");
        float distanceC = sc.nextFloat();

        // Création de l'objet Course
        Course course = new Course(id_u, idD, tempsTC, distanceC);
        CourseService cs = new CourseService();
        cs.addCourse(course);
        return course;
    }

    public static void GenerateCAPeriode() throws SQLException {
        CourseService cs = new CourseService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est le jour de debut de votre calcul de CA");
        int jourD = sc.nextInt();
        System.out.println("Quel est le mois de debut de votre calcul de CA");
        int moisD = sc.nextInt();
        System.out.println("Quel est l'anne de debut de votre calcul de CA");
        int anneeD = sc.nextInt();
        LocalDate dateDebut = LocalDate.of(anneeD, moisD, jourD);
        System.out.println("Quel est le jour de fin de votre calcul de CA");
        int jourF = sc.nextInt();
        System.out.println("Quel est le mois de fin de votre calcul de CA");
        int moisF = sc.nextInt();
        System.out.println("Quel est l'anne de fin de votre calcul de CA");
        int anneeF = sc.nextInt();
        LocalDate dateFin = LocalDate.of(anneeF, moisF, jourF);
        System.out.printf(US,"Votre ca de %s à %s est de : %.2f € ", dateDebut.toString(), dateFin.toString(), cs.CalculerMarge(dateDebut,dateFin));
    }

    public static void GenerateCAAnne() throws SQLException {
        CourseService cs = new CourseService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est l'anne de votre calcul de CA");
        int annee = sc.nextInt();
        cs.CA_Anne_mois(annee);
    }


}
