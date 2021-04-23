import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String url = "jdbc:mysql://localhost:3306/skillbox";
    private static String user = "root";
    private static String pass = "root";

    public static Connection getConnectionToDB() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
