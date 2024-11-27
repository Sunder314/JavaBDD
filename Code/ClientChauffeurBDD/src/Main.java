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
        cs.recapClient(1);





    }
}