package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

     User findById(Long id);

     List<User> getUser();

     void saveUser(String name, String surname, int age);

     void updateUser(Long id, String name, String surname, int age);

     void deleteUser(Long id);
}
