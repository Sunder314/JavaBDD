package interfaces.User;

import java.sql.SQLException;
import java.util.List;

import Class.User.User;

public interface UserInterface {
    public int addUser(User user) throws SQLException;
    public User getUser(int id) throws SQLException;
    public List<User> getUsers(int limit) throws SQLException;
    public int deleteUser(int id) throws SQLException;
    public boolean chekUser(int id) throws SQLException;
}
