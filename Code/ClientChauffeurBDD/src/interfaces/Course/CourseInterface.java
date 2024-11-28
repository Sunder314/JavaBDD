package interfaces.Course;

import Class.Course.Course;
import Class.Driver.Driver;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface CourseInterface {
    public int addCourse(Course Course) throws SQLException;
    public boolean chekCourse(int id) throws SQLException;
    public Course getCourse(int id) throws SQLException;
    public List<Course> getCourses(int limit) throws SQLException;
    public int deleteCourse(int id) throws SQLException;
    public void recapClient(int id) throws SQLException;
    public List<Driver> DriverMostKM(int limit) throws SQLException;
    public Time TempsMoyTrajet() throws SQLException;
    public float CalculerMarge(LocalDate dateDebut, LocalDate dateFin) throws SQLException;
    public void CA_Anne_mois(int anne) throws SQLException;

}
