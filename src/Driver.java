import java.sql.*;

/**
 * Created by OwenTsai on 2018-11-09.
 */
public class Driver {
    private static Driver driver;
    private Connection con;
    private Statement stmt;


    /*
     * Constructor
     */
    private Driver() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
        }
        // connect to Oracle
        connect();
    }

    public static Driver getInstance() {
        if (driver == null)
            driver = new Driver();
        return driver;
    }

    /*
     * connects to Oracle database named using username and password
     */
    private void connect() {
        String username = "ora_f6c1b";
        String password = "a26525155";
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug", username, password);
            System.out.println("\nConnected to Oracle");
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage() + "\nFailed to connect to Oracle");
        }
    }

    /*
     * execute any SQL statements alter the database (update, delete, insert)
     */
    public String executeAlter(String sqlstmt) {
        try {
            stmt.executeUpdate(sqlstmt);
            con.commit();
            return "1";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }


    /*
     * execute query statements
     */
    public ResultSet executeQuery(String sqlstmt) {
        try {
            return stmt.executeQuery(sqlstmt);
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage() + "\nUnable to execute: " + sqlstmt);
            return null;
        }
    }

    /*
     * disconnect from Oracle database
     */
    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("\nFailed to disconnect from Oracle");
        }
    }

}
