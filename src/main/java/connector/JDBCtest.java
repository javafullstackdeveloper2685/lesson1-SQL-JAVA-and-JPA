package connector;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCtest {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/sergei?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin";

    private static final Logger logger = LogManager.getLogger(Logger.class);

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void saveBicycle(int id, String size, String userName) {
        String insertQuery = "INSERT INTO bicycles (id, size, user_name) VALUES (?, ?, ?)";

        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, size);
            preparedStatement.setString(3, userName);

            int rowsInserted = preparedStatement.executeUpdate();
            logger.info("{} row(s) inserted successfully.", rowsInserted);

        } catch (SQLException e) {
            logger.error("Error do something: {}", e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hey");

        JDBCtest jdbc = new JDBCtest();

        jdbc.saveBicycle(3, "Small", "Bob");
    }
}
