package pl.krysinski.sqljdbc.service;

import org.springframework.stereotype.Service;
import pl.krysinski.sqljdbc.dao.UserDao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addAll() throws IOException {
        userDao.addUsersToDb();
    }

    @Override
    public List<Map<String, Object>> getAll() {
        return userDao.getAll();
    }
}
