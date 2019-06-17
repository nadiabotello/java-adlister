import MySQL.Config;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao();
        }
        return adsDao;
    }

    private static Employees employeesDao;

    public static Employees getEmployeesDao() {
        if (employeesDao == null) {
            employeesDao = new MySQLEmployeeDao();
        }
        return employeesDao;
    }
}
