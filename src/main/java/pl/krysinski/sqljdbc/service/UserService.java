package pl.krysinski.sqljdbc.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {

    void addAll() throws IOException;
    List<Map<String, Object>> getAll();

}
