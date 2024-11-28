package Service.Driver;

import Class.Driver.Driver;
import Class.Driver.TypeDriver;
import Class.User.TypeUser;
import Class.User.User;
import connection.Dao;
import interfaces.Driver.DriverInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DriverService implements DriverInterface {

    private static Dao dao = new Dao();
    private static ResultSet rs;

    @Override
    public int addDriver(Driver driver) throws SQLException {
        try {
            String rq = String.format("INSERT INTO [Driver] (nomD,prenomD,date_naissanceD,typeD) VALUES ('%s','%s','%s', '%s')", driver.getNom(), driver.getPrenom(), driver.getDate_naissance(), driver.getType().name());
            dao.executeUpdate(rq);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean chekDriver(int id) throws SQLException {
        rs = dao.executeQuery(String.format("SELECT COUNT(idD) FROM [Driver] WHERE idD = %d", id));
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }

    @Override
    public Driver getDriver(int id) throws SQLException {
        Driver driver = new Driver();

        if (!chekDriver(id)) {
            return null;
        }
        rs = dao.executeQuery(String.format("SELECT * FROM [Driver] WHERE idD = %d", id));
        if (rs.next()) {
            driver.setNom(rs.getString("nomD"));
            driver.setPrenom(rs.getString("prenomD"));
            driver.setDate_naissance(LocalDate.parse(rs.getString("date_naissanceD")));
            driver.setType(TypeDriver.valueOf(rs.getString("typeD")));
            return driver;
        }
        return null;
    }

    @Override
    public List<Driver> getDrivers(int limit) throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        rs = dao.executeQuery(String.format("SELECT TOP (%d) [idD]\n" +
                "      ,[nomD]\n" +
                "      ,[prenomD]\n" +
                "      ,[date_naissanceD]\n" +
                "      ,[typeD]\n" +
                "  FROM [Driver]", limit));
        while (rs.next()) {
            Driver driver = new Driver();
            driver.setNom(rs.getString("nomD"));
            driver.setPrenom(rs.getString("prenomD"));
            driver.setDate_naissance(LocalDate.parse(rs.getString("date_naissanceD")));
            driver.setType(TypeDriver.valueOf(rs.getString("typeD")));
            drivers.add(driver);
        }
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        return drivers;
    }

    @Override
    public int deleteDriver(int id) throws SQLException {
        if (!chekDriver(id)) {
            return -2;
        } else {
            dao.executeUpdate(String.format("DELETE FROM [Driver] WHERE idD = %d", id));
            return 1;
        }
    }

    public int nbChauffeurType(TypeDriver type) throws SQLException {
        rs = dao.executeQuery(String.format("SELECT COUNT(idD) FROM [Driver] where typeD = '%s'", type.name()));
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void nbChauffeurAllType() throws SQLException {
        DriverService ds = new DriverService();
        System.out.printf("['%s' : %d / '%s' : %d]", TypeDriver.MOTARD.name(), ds.nbChauffeurType(TypeDriver.MOTARD), TypeDriver.VOITURE.name(), ds.nbChauffeurType(TypeDriver.VOITURE));
    }

    public Driver getOlderDriver() throws SQLException {
        Driver driver = new Driver();

        rs = dao.executeQuery("SELECT TOP (1) [idD],\n" +
                "       [nomD],\n" +
                "       [prenomD],\n" +
                "       [date_naissanceD],\n" +
                "       [date_inscriptionD],\n" +
                "       [typeD]\n" +
                "FROM [dbo].[Driver]\n" +
                "ORDER BY [date_naissanceD] ASC;\n");
        if (rs.next()) {
                driver.setNom(rs.getString("nomD"));
                driver.setPrenom(rs.getString("prenomD"));
                driver.setDate_naissance(LocalDate.parse(rs.getString("date_naissanceD")));
                driver.setType(TypeDriver.valueOf(rs.getString("typeD")));
                return driver;
        }
        return null;
    }
}

