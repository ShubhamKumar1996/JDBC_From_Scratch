import java.sql.*;

class InsertJDBC {
    public static void main(String[] args) {
        try {

            // Load Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Create connection
            String url = "jdbc:mysql://localhost:3306/person";
            String user = "root";
            String password = "userpass";

            Connection con = DriverManager.getConnection(url, user, password);

            if(con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is created...");
            }

            // Create a query
            String createTableQuery = "create table person1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";

            // Create a statement
            Statement statement = con.createStatement();

            statement.executeUpdate(createTableQuery);

            System.out.println("Table Created");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}