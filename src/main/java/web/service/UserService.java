package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User findUser(Long id);

    User updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();
}
