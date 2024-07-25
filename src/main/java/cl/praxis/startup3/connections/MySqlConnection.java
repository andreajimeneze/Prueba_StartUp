package cl.praxis.startup3.connections;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class MySqlConnection {
    private static MySqlConnection instance;
    private Connection connection;

    private MySqlConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/startup";
        final String USERNAME = "root";
        final String PASSWORD = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
    }

        public static MySqlConnection getInstance()  {
            try {
                if(instance == null) {
                    instance = new MySqlConnection();
                } else if (instance.getConnection().isClosed()) {
                        instance = new MySqlConnection();
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return instance;
        }

    public Connection getConnection() throws SQLException {
        return connection;
    }
}
