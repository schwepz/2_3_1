
package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}