import java.sql.*;

class UpdateTable {
    public static void main(String[] args) {
        try {
            // Load driver.
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Create connection
            String url = "jdbc:mysql://localhost:3306/person";
            String username = "root";
            String password = "userpass";

            Connection con = DriverManager.getConnection(url, username, password);

            if(con.isClosed()) {
                System.out.println("Connection is closed");
            }

            // Create Query
            String updateQuery = "UPDATE person1 SET tName = 'kumar' WHERE tName = 'Nahan'";

            // Create Statement
            Statement statement = con.createStatement();

            // execute Query
            statement.executeUpdate(updateQuery);

            System.out.println("Updated Table");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}