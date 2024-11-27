package Service.Driver;

import Class.Driver.Driver;
import interfaces.Driver.DriverInterface;

import java.sql.SQLException;
import java.util.List;

public class DriverService implements DriverInterface {

    @Override
    public int addDriver(Driver Driver) throws SQLException {
        return 0;
    }

    @Override
    public Driver getDriver(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Driver> getDrivers() throws SQLException {
        return List.of();
    }

    @Override
    public int deleteDriver(int id) throws SQLException {
        return 0;
    }
}
