package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getUser() {
        return userDao.getUser();
    }

    @Override
    public void saveUser(String name, String surname, int age) {
        User user = new User(name, surname, age);
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(Long id, String name, String surname, int age) {
        User user = findById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
