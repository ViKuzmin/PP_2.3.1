package crud.services;

import crud.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(long id);
    User getUserById(long id);
    void updateUser(User user);
}
