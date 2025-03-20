package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbConnection {
    public static Connection c;
    public static Statement st;

    static {
        try {
            // JDBC code here
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/extra", "root", "Ankur@1234");
            st = c.createStatement();
        } catch (Exception ex) {
            System.out.println("Not connected");
        }
    }

    public static Connection getConnection() {
        return c;
    }
}
