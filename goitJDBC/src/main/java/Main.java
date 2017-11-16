import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/initDB", "root", "1111");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CRUDcomp cruDcomp = new CRUDcomp();
        Companies google = new Companies(1, "Google");
        Companies yahoo = new Companies(2, "Yahoo");

        cruDcomp.create(connection, google);
        cruDcomp.create(connection, yahoo);

        List<Companies> companiesList = cruDcomp.read(connection);
        for (Companies companie : companiesList) {
            System.out.println(companie);
        }
        cruDcomp.delete(connection, 1);

        Companies yahooo = new Companies(2, "Yahooo");
        cruDcomp.update(connection, yahooo);

        List<Companies> companiesList2 = cruDcomp.read(connection);
        for (Companies companie : companiesList2) {
            System.out.println(companie);
        }

    }

}
