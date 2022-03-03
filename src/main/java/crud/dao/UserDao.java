package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDao {

   List<User> getAllUsers();
   void addUser(User user);
   void delete(long id);
   User getUserById(long id);
   void updateUser(User user);
}
