package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }
    public User getUserById(Long id) {
        return userDao.findById(id);
    }
    public void save(User user) {
        userDao.save(user);
    }
    public void update(Long id, User user) {
        userDao.update(id, user);

    }
    public void delete(Long id) {
        userDao.delete(id);
    }



}
