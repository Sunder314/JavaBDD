import Class.User.TypeUser;
import Class.User.User;
import Service.User.UserService;
import connection.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        Dao dao = new Dao();
        ResultSet rs;
        String rq;
        User user = new User("Audouy","Julia", LocalDate.parse("2004-09-08"), TypeUser.ETUDIANT);
        UserService us = new UserService();
        us.deleteUser(4);




    }
}