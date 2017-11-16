import java.sql.Connection;
import java.util.List;

public interface CRUD<T> {

   void create(Connection connection, T object);
   List<T> read(Connection connection);
   void update(Connection connection, T object);
   void delete (Connection connection, int id);
}
