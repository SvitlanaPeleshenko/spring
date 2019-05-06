package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.User;

import java.util.Collection;

public interface UserDao {

    User getUserByEmail(String email);
    User saveUser (User user);
    void removeUser (User user);
    User getUserById (Long id);
    Collection<User> getAllUsers();

}
