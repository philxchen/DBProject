package dbbeans;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * provides access to our database
 */

public class DataAccess {
    private static Connection dbConnection = null;

    public static Connection getConnection() {
        if (dbConnection != null) {
            return dbConnection;
        } else {
            Properties properties;
            try {
                properties = new Properties();
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream in = classLoader.getResourceAsStream("db.properties");
                properties.load(in);
                in.close();

                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");

                Class.forName(driver).newInstance();
                dbConnection = DriverManager.getConnection(url, username, password);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return dbConnection;
        }
    }

}