import java.sql.*;
import java.io.*;

class ShowTableData {
    public static void main(String[] args) {
        try {
            // Load Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Create connection
            String url = "jdbc:mysql://localhost:3306/person";
            String username = "root";
            String password = "userpass";
            Connection con = DriverManager.getConnection(url, username, password);
            
            // Create Query
            String selectQuery = "SELECT * FROM person1";

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute Query
            ResultSet set = stmt.executeQuery(selectQuery);

            System.out.println("Table Data");

            while(set.next()) {
                System.out.println("Name " + set.getString("tName") + " City " + set.getString("tCity"));
            }

            System.out.println("Completed");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}