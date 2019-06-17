import MySQL.Config;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLEmployeeDao implements Employees {

    private Connection connection;

    public MySQLEmployeeDao() {
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

    private Employee getEmployeesResults(ResultSet rs) throws SQLException {

        return new Employee(
                rs.getLong("birth_date"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("gender"),
                rs.getLong("hire_date")
        );
    }

    private List<Employee> EmployeesResults(ResultSet rs) throws SQLException {
        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            employees.add(getEmployeesResults(rs));
        }
        return employees;
    }

    @Override
    public List<Employee> findOne(long id) {
        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees LIMIT 1");
            return EmployeesResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("error", e);
        }
    }

    @Override
    public List<Employee> findAll() {
        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees LIMIT 10");
            return EmployeesResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("error", e);
        }


    }

    @Override
    public long update(long id) {
        return 0;
    }

    @Override
    public long save(Employee employee) {
        String insertNew = "INSERT INTO employees(birth_date, first_name, last_name, gender, hire_date) VALUES "
                + "(" + employee.getBirth_date() + ", "
                + "'" + employee.getFirst_name() +"', "
                + "'" + employee.getLast_name() + "',"
                + "'" + employee.getGender() +"', "
                + "'" + employee.getHire_date() +"')";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(insertNew, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("New Employee ID: " + rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("error insert", e);
        }

        return 0;
    }

    @Override
    public long delete(long id) {
        return 0;
    }

}
