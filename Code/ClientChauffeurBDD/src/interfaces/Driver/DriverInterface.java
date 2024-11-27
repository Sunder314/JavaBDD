package interfaces.Driver;

import Class.Driver.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriverInterface {
    public int addDriver(Driver Driver) throws SQLException;
    public Driver getDriver(int id) throws SQLException;
    public List<Driver> getDrivers() throws SQLException;
    public int deleteDriver(int id) throws SQLException;
}
