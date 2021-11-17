import java.sql.*;
import java.io.*;

class InsertUsingPreparedStatement {
    public static void main(String[] args) {
        try {
            // load Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Create connection
            String url = "jdbc:mysql://localhost:3306/person";
            String username = "root";
            String password = "userpass";

            Connection con = DriverManager.getConnection(url, username, password);
            
            if(con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection created...");
            }

            // Create query;
            String query = "insert into person1(tName, tCity) values (?,?)";

            // get the preparedStatement object
            PreparedStatement pstmt = con.prepareStatement(query);

            // set the values to query
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name: ");
            String name = br.readLine();
            System.out.println("Enter City: ");
            String city = br.readLine();
            
            pstmt.setString(1, name);
            pstmt.setString(2, city);

            pstmt.executeUpdate();

            System.out.println("Inserted");

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}