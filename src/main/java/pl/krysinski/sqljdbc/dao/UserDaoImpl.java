package pl.krysinski.sqljdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.krysinski.sqljdbc.model.User;
import pl.krysinski.sqljdbc.utils.Reader;


import java.io.IOException;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private Reader csvReader;
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public UserDaoImpl(Reader csvReader, JdbcTemplate jdbcTemplate) {
        this.csvReader = csvReader;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addUsersToDb() throws IOException {
        String truncateSql = "TRUNCATE TABLE users";
        jdbcTemplate.execute(truncateSql);
        List<User> userList = csvReader.readData();


        String sql = "INSERT INTO users VALUES (?,?,?,?,?,?)";
        for (User user : userList) {
            jdbcTemplate.update(
                    sql,
                    Long.parseLong(user.getId()),
                    user.getEmail(),
                    user.getFirst_name(),
                    user.getGender(),
                    user.getIp_address(),
                    user.getLast_name()

            );
        }

    }

    @Override
    public List<Map<String, Object>> getAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.queryForList(sql);

    }
}
