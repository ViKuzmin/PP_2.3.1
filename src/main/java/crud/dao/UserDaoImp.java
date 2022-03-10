package crud.dao;

import crud.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    public List<User> getAllUsers() {

        return manager.createQuery("SELECT user from User user").getResultList();
    }

    public void addUser(User user) {
        manager.persist(user);
    }

    public void delete(long id) {

        User user = manager.find(User.class, id);
        manager.remove(user);
    }

    public User getUserById(long id) {

        return manager.find(User.class, id);
    }

    public void updateUser(User user) {

        manager.merge(user);
    }
}
