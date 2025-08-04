package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getUser() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(Long id, String name, String surname, int age) {
        User user = findById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
    }

    public void deleteUser(Long id) {
        User user = findById(id);
        entityManager.remove(user);
    }
}