import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDskills implements CRUD <Skills> {
    @Override
    public void create(Connection connection, Skills object) {
        String sql = "INSERT INTO Skills (name) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getSkillName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Skills> read(Connection connection) {
    List<Skills> result = new ArrayList<>();
        try(
    Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Skills");

        while (resultSet.next()) {
            Skills skills = new Skills();
            skills.setSkillId(resultSet.getInt("idSkills"));
            skills.setSkillName(resultSet.getString("name"));
            result.add(skills);
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
        return result;
    }

    @Override
    public void update(Connection connection, Skills object) {
        String sql = "UPDATE Skills SET name = ? WHERE idSkills = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, object.getSkillName());
            statement.setInt(2, object.getSkillId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Connection connection, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Skills WHERE idSkills=?");
            statement.setInt(1, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
