package pl.krysinski.sqljdbc.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserDao {

    void addUsersToDb() throws IOException;

    List<Map<String, Object>> getAll();
}
