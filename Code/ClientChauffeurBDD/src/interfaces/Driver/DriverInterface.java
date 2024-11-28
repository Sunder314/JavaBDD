package interfaces.Driver;

import Class.Driver.Driver;
import Class.Driver.TypeDriver;

import java.sql.SQLException;
import java.util.List;

public interface DriverInterface {
    public int addDriver(Driver Driver) throws SQLException;
    public boolean chekDriver(int id) throws SQLException;
    public Driver getDriver(int id) throws SQLException;
    public List<Driver> getDrivers(int limit) throws SQLException;
    public int deleteDriver(int id) throws SQLException;
    public int nbChauffeurType(TypeDriver type) throws SQLException;
    public void nbChauffeurAllType() throws SQLException;
    public Driver getOlderDriver() throws SQLException;


}
