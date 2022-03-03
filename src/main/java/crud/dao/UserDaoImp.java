package crud.dao;

import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public List<User> getAllUsers() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        return manager.createQuery("SELECT user from User user").getResultList();
    }

    public void addUser(User user) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (IllegalStateException e) {
            manager.getTransaction().rollback();
            throw new IllegalStateException();
        }
    }

    public void delete(long id) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            manager.getTransaction().begin();
            User user = manager.find(User.class, id);
            manager.remove(user);
            manager.getTransaction().commit();
        } catch (IllegalStateException e) {
            manager.getTransaction().rollback();
            throw new IllegalStateException();
        }
    }

    public User getUserById(long id) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        return manager.find(User.class, id);
    }

    public void updateUser(User user) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(user);
            manager.getTransaction().commit();
        } catch (IllegalStateException e) {
            manager.getTransaction().rollback();
            throw new IllegalStateException();
        }
    }
}
