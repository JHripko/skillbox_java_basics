import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement
                                    .executeQuery("SELECT purchaselist.course_name, COUNT('student_name') / 8 as avg_count " +
                                                          "FROM purchaselist " +
                                                          "WHERE YEAR(purchaselist.subscription_date) = '2018' " +
                                                          "GROUP BY purchaselist.course_name");

            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String avgCount = resultSet.getString("avg_count");

                System.out.println(courseName + "\t" + avgCount);
            }

            resultSet.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
