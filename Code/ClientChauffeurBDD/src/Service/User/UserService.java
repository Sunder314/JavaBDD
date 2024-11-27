package Service.User;

import Class.User.TypeUser;
import Class.User.User;
import connection.Dao;
import interfaces.User.UserInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserInterface {

    private Dao dao = new Dao();
    private ResultSet rs;


    @Override
    public int addUser(User user) throws SQLException {
            try {
                String rq = String.format("INSERT INTO [User] (nom_u,prenom_u,date_naissance_u,type_u) VALUES ('%s','%s','%s', '%s')", user.getNom(),user.getPrenom(),user.getDate_naissance(),user.getType().name());
                dao.executeUpdate(rq);
                return 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
    }

    @Override
    public boolean chekUser(int id) throws SQLException {
        rs = dao.executeQuery(String.format("SELECT COUNT(id_u) FROM [User] WHERE id_u = %d", id));
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }


    @Override
    public User getUser(int id) throws SQLException {
        User user = new User();

        if (!chekUser(id)) {
            return null;
        }
        rs = dao.executeQuery(String.format("SELECT * FROM [User] WHERE id_u = %d", id));
        if (rs.next()) {
            user.setNom(rs.getString("nom_u"));
            user.setPrenom(rs.getString("prenom_u"));
            user.setDate_naissance(LocalDate.parse(rs.getString("date_naissance_u")));
            user.setType(TypeUser.valueOf(rs.getString("type_u")));
            return user;
        }
        return null;
    }

    @Override
    public List<User> getUsers(int limit) throws SQLException {
        List<User> users = new ArrayList<>();
        rs = dao.executeQuery(String.format("SELECT TOP (%d) [id_u]\n" +
                "      ,[nom_u]\n" +
                "      ,[prenom_u]\n" +
                "      ,[date_naissance_u]\n" +
                "      ,[type_u]\n" +
                "  FROM [User]", limit));
        while (rs.next()) {
            User user = new User();
            user.setNom(rs.getString("nom_u"));
            user.setPrenom(rs.getString("prenom_u"));
            user.setDate_naissance(LocalDate.parse(rs.getString("date_naissance_u")));
            user.setType(TypeUser.valueOf(rs.getString("type_u")));
            users.add(user);
        }
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @Override
    public int deleteUser(int id) throws SQLException {
        if (!chekUser(id)) {
            return -2;
        } else {
            dao.executeUpdate(String.format("DELETE FROM [User] WHERE id_u = %d", id));
            return 1;
        }
    }

    public int moyAncUser() throws SQLException {
        rs = dao.executeQuery("SELECT AVG(DATEDIFF(DAY, date_inscription_u, GETDATE())) AS anciennete_moyenne_jours\n" +
                "FROM [User]");
        if (rs.next()) {
            return rs.getInt("anciennete_moyenne_jours");
        }
        return -1;
    }
}
