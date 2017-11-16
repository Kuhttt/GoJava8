import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDdev implements CRUD<Developers>  {
    @Override
    public void create(Connection connection, Developers object) {
        String sql = "INSERT INTO Developers (name) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getDevName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Developers> read(Connection connection) {
        List<Developers> result = new ArrayList<>();
        try(
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Developers");

            while (resultSet.next()) {
                Developers developers = new Developers();
                developers.setDevId(resultSet.getInt("idDevelopers"));
                developers.setDevName(resultSet.getString("name"));
                result.add(developers);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public void update(Connection connection, Developers object) {
        String sql = "UPDATE Developers SET name = ? WHERE idDevelopers = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getDevName());
            statement.setInt(2, object.getDevId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void delete(Connection connection, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Projects WHERE idProjects=?");
            statement.setInt(1, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
