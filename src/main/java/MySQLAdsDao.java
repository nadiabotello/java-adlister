import MySQL.Config;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao() {

        try {
            DriverManager.registerDriver(new Driver());
            Config config = new Config();

            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Ad getAdsResults(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> AdsResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(getAdsResults(rs));
        }
        return ads;
    }

    @Override
    public List<Ad> all() {
        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return AdsResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("error", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        String insertNew = "INSERT INTO ads(user_id, title, description) VALUES "
                + "(" + ad.getUserId() + ", "
                + "'" + ad.getTitle() +"', "
                + "'" + ad.getDescription() + "')";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(insertNew, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("error insert", e);
        }

        return 0L;
    }
}



