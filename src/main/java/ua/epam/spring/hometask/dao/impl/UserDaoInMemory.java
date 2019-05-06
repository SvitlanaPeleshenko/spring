package ua.epam.spring.hometask.dao.impl;

import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserDaoInMemory implements UserDao {

    private Map<Long, User> usersById = new HashMap<>();
    private long userId = 0;

    @Override
    public User getUserByEmail(String email) {
        return usersById.values().stream().filter(user->user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public User saveUser(User user) {
        if (user.getId() != null) {
            if (usersById.get(user.getId()) == null) {
                user.setId(++userId);
                usersById.put(userId, user);
            } else
                usersById.put(user.getId(), user);

        } else {
            user.setId(++userId);
            usersById.put(userId, user);
        }

        return user;
    }

    @Override
    public void removeUser(User user) {
        usersById.remove(user.getId(),user);
    }

    @Override
    public User getUserById(Long id) {
        return usersById.get(id);
    }

    @Override
    public Collection<User> getAllUsers() {
        return usersById.values() ;
    }
}
