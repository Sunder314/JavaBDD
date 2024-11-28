package Service.Course;

import Class.Course.Course;
import Class.Driver.Driver;
import Class.Driver.TypeDriver;
import Class.User.TypeUser;
import Class.User.User;
import Service.Driver.DriverService;
import Service.User.UserService;
import connection.Dao;
import interfaces.Course.CourseInterface;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static Class.TimeConversion.TimeConversion.removeFraction;
import static java.util.Locale.*;

public class CourseService implements CourseInterface {

    private static Dao dao = new Dao();
    private static ResultSet rs;

    @Override
    public int addCourse(Course course) throws SQLException {
        try {
            String rq = String.format("INSERT INTO [Course] (id_u,idD,tempsTC,distanceC) VALUES (%d,%d,'%s', '%s')", course.getId_u(), course.getIdD(), course.getTempsTC(), course.getDistanceC());
            dao.executeUpdate(rq);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    @Override
    public boolean chekCourse(int id) throws SQLException {
        rs = dao.executeQuery(String.format("SELECT COUNT(idC) FROM [Course] WHERE idC = %d", id));
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }

    @Override
    public Course getCourse(int id) throws SQLException {
        Course course = new Course();

        if (!chekCourse(id)) {
            return null;
        }
        rs = dao.executeQuery(String.format("SELECT * FROM [Course] WHERE idC = %d", id));
        if (rs.next()) {
            course.setId_u(rs.getInt("id_u"));
            course.setIdD(rs.getInt("idD"));
            String validTimeString = removeFraction(rs.getString("tempsTC"));
            course.setTempsTC(Time.valueOf(validTimeString));
            course.setDistanceC(rs.getFloat("distanceC"));
            return course;
        }
        return null;
    }

    @Override
    public List<Course> getCourses(int limit) throws SQLException {
        List<Course> courses = new ArrayList<>();
        rs = dao.executeQuery(String.format("SELECT TOP (1000) [idC]\n" +
                "      ,[id_u]\n" +
                "      ,[idD]\n" +
                "      ,[dateC]\n" +
                "      ,[tempsTC]\n" +
                "      ,[distanceC]\n" +
                "  FROM [TaxiSimulation].[dbo].[Course]", limit));
        while (rs.next()) {
            Course course = new Course();
            course.setId_u(rs.getInt("id_u"));
            course.setIdD(rs.getInt("idD"));
            String validTimeString = removeFraction(rs.getString("tempsTC"));
            course.setTempsTC(Time.valueOf(validTimeString));
            course.setDistanceC(rs.getFloat("distanceC"));
            courses.add(course);
        }
        for (Course course : courses) {
            System.out.println(course);
        }
        return courses;
    }

    @Override
    public int deleteCourse(int id) throws SQLException {
        if (!chekCourse(id)) {
            return -2;
        } else {
            dao.executeUpdate(String.format("DELETE FROM [Course] WHERE idC = %d", id));
            return 1;
        }
    }

    public static float distanceClient(int id) throws SQLException {
        rs = dao.executeQuery(String.format("SELECT SUM(distanceC) as somme from [Course] where id_u = %d", id));
        if (rs.next()) {
            return rs.getFloat("somme");
        }
        return -2;
    }

    public static int nbCourseClient(int id) throws SQLException {
        rs = dao.executeQuery(String.format("SELECT COUNT(idC) as count FROM [Course] WHERE id_u = %d", id));
        if (rs.next()) {
            return rs.getInt("count");
        }
        return -2;
    }

    @Override
    public void recapClient(int id) throws SQLException {
        UserService us = new UserService();
        CourseService cs = new CourseService();
        System.out.printf("Client : '%s %s'  | Nombre de course(s) : %d | " +
                " Distance parcouru : %f KM",us.getUser(id).getPrenom(),us.getUser(id).getNom(),nbCourseClient(id),distanceClient(id));
    }

    public List<Driver> DriverMostKM(int limit) throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        DriverService ds = new DriverService();
        rs = dao.executeQuery(String.format("select top (%d) idD,sum(distanceC) as totdist from [Course] Group by idD order by totdist desc;",limit));
        while (rs.next()) {
            Driver driver = ds.getDriver(rs.getInt("idD"));
            drivers.add(driver);
        }
        return drivers;
    }

    public Time TempsMoyTrajet() throws SQLException {
        rs = dao.executeQuery("SELECT TOP (1) \n" +
                "       CAST(DATEADD(SECOND, AVG(DATEDIFF(SECOND, '00:00:00', tempsTC)), '00:00:00') AS TIME) AS avg_temps\n" +
                "FROM [Course];");
        if (rs.next()) {
            String validTimeString = removeFraction(rs.getString("avg_temps"));
            return Time.valueOf(validTimeString);
        }
        return null;
    }

    public float CalculerMarge(LocalDate dateDebut, LocalDate dateFin) throws SQLException {
        DriverService ds = new DriverService();
        Float prix = 0F;
        Float CA = 0F;
        rs = dao.executeQuery(String.format("select * from [Course] where [dateC] " +
                "between '%sT00:00:00' and '%sT00:00:00'",dateDebut,dateFin));
        while (rs.next()) {
            Driver driver = ds.getDriver(rs.getInt("idD"));
            String validTimeString = removeFraction(rs.getString("tempsTC"));
            float distance  = rs.getFloat("distanceC");
            Time time = Time.valueOf(validTimeString);
            long seconds = time.toLocalTime().toSecondOfDay();
            if (driver.getType().name().equals("MOTARD")){
                prix = 5F + (distance*0.3F) + (seconds*1.5F);
            } else {
                prix = 8F + (distance*0.3F) + (seconds*1.5F);
            }
            CA = CA + (prix*0.1F);
        }
        return CA;
    }

    public void CA_Anne_mois(int anne) throws SQLException {
        Arrays Arrays = null;
        List<String> mois = Arrays.asList("Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout",
                "Septembre", "Octobre", "Novembre", "Decembre");

        for (int k = 1; k < mois.size(); k++) {
            System.out.printf(US, "'%s' %.2f €" + "\n", mois.get(k-1), CalculerMarge(LocalDate.of(anne,k,1), LocalDate.of(anne,k+1,1)));
        }
        System.out.printf(US, "'%s' %.2f €" + "\n", mois.get(11), CalculerMarge(LocalDate.of(anne,12,1), LocalDate.of(anne,12,31)));



    }
}
