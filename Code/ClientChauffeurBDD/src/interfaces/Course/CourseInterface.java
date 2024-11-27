package interfaces.Course;

import Class.Course.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseInterface {
    public int addCourse(Course Course) throws SQLException;
    public boolean chekCourse(int id) throws SQLException;
    public Course getCourse(int id) throws SQLException;
    public List<Course> getCourses(int limit) throws SQLException;
    public int deleteCourse(int id) throws SQLException;
    public void recapClient(int id) throws SQLException;

}
