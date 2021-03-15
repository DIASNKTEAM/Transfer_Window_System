package data.interfaces;

import java.sql.*;

public interface IDB {
    // method to connect with database
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
