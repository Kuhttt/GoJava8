import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDcust implements CRUD <Customers> {
    @Override
    public void create(Connection connection, Customers object) {
        String sql = "INSERT INTO Customers (name) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getCustName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Customers> read(Connection connection) {

        List<Customers> result = new ArrayList<>();
        try(
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Customers");

            while (resultSet.next()) {
                Customers customers = new Customers();
                customers.setCustId(resultSet.getInt("idCustomers"));
                customers.setCustName(resultSet.getString("name"));
                result.add(customers);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Connection connection, Customers object) {
        String sql = "UPDATE Customers SET name = ? WHERE idCustomers = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getCustName());
            statement.setInt(2, object.getCustId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Connection connection, int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Customers WHERE idCustomers=?");
            statement.setInt(1, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
