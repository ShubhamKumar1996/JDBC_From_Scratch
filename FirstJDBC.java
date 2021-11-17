// Program for JDBC 1 program
import java.sql.*;
class FirstJDBC {
    public static void main(String[] args) {
        try {
            // load the driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Creating a connection
            String url="jdbc:mysql://localhost:3306/person";
            String username="root";
            String password="userpass";
            
            Connection con = DriverManager.getConnection(url, username, password);
            
            if(con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is created");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}