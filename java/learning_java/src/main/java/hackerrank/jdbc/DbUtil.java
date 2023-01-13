package hackerrank.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbUtil {
    private static String DB_URL = "jdbc:postgresql://localhost:5432/tata_grocery";
    private static Properties properties;

    static {
        System.out.println("setting up block");

        //DB_URL = "jdbc:postgresql://localhost:5432/grocery";
        properties = new Properties();
        properties.setProperty("user", "tata_grocery_usr");
        properties.setProperty("password", "tata_grocery_pwd");
        properties.setProperty("ssl", "true");
    }

    public static Connection getConnection() {
        Connection connection;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, properties);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
