package crud.services;

import crud.dao.UserDao;
import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        System.out.println(userDao.getAllUsers());
        return userDao.getAllUsers();
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.delete(id);
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
