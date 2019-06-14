package MySQL;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class MySQL {

    public static void main(String[] args) {

        try {

            DriverManager.registerDriver(new Driver());

            Config config = new Config();
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM City WHERE CountryCode = 'USA'");

            while (rs.next()) {
                System.out.println("Here's a city:");
                System.out.println("  id: " + rs.getInt("id"));
                System.out.println("  name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
