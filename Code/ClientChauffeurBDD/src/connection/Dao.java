package connection;

import java.sql.*;

public class Dao {
        private final String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=TaxiSimulation";
        private final String dbUser= "NomUtilisateur";
        private final String dbPass= "mdp";
        private Connection con;

        public Dao() {
            try {
                con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        public Statement getStatement() throws SQLException {
            return con.createStatement();
        }
        public ResultSet executeQuery(String query) throws SQLException {
            return con.createStatement().executeQuery(query);
        }
        public void  executeUpdate(String query) throws SQLException {
            con.createStatement().executeUpdate(query);
        }
}
