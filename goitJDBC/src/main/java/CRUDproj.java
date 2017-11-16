import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDproj implements CRUD <Projects> {
    @Override
    public void create(Connection connection, Projects object) {
        String sql = "INSERT INTO Projects (name) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getProjName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Projects> read(Connection connection) {
        List<Projects> result = new ArrayList<>();
        try(
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Projects");

            while (resultSet.next()) {
                Projects projects = new Projects();
                projects.setProjId(resultSet.getInt("idProjects"));
                projects.setProjName(resultSet.getString("name"));
                result.add(projects);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Connection connection, Projects object) {
        String sql = "UPDATE Projects SET name = ? WHERE idProjects = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getProjName());
            statement.setInt(2, object.getProjId());
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
