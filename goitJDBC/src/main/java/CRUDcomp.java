import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDcomp implements CRUD<Companies> {
    @Override
    public void create(Connection connection, Companies object) {
        String sql = "INSERT INTO Companies (name) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getCompName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Companies> read(Connection connection) {
        List<Companies> result = new ArrayList<>();
        try(
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Companies");

            while (resultSet.next()) {
                Companies companies = new Companies();
                companies.setCompId(resultSet.getInt("idCompanies"));
                companies.setCompName(resultSet.getString("name"));
                result.add(companies);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public void update(Connection connection, Companies object) {
        String sql = "UPDATE Companies SET name = ? WHERE idCompanies = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getCompName());
            statement.setInt(2, object.getCompId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Connection connection, int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Companies WHERE idCompanies=?");
            statement.setInt(1, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    }

