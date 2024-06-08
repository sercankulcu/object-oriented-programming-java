
import java.sql.*;

public class MysqlDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Register the MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Create a connection to the database
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";
        Connection connection = DriverManager.getConnection(url, username, password);

        // Create a statement
        Statement statement = connection.createStatement();

        // Insert a new record
        String sql = "INSERT INTO users (name, email) VALUES ('John Doe', 'johndoe@example.com')";
        statement.executeUpdate(sql);

        // Update an existing record
        sql = "UPDATE users SET name='Jane Doe' WHERE id=1";
        statement.executeUpdate(sql);

        // Delete a record
        sql = "DELETE FROM users WHERE id=2";
        statement.executeUpdate(sql);

        // List all records
        sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);

        // Iterate over the results
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
        }

        // Close the connection
        connection.close();
    }
}