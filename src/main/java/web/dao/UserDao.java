package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    User findById(Long id);

    List<User> getUser();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
