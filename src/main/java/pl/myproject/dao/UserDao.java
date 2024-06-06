package pl.myproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.myproject.entity.Car;
import pl.myproject.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) { entityManager.merge(user); }

    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    public List<User> find() {
        return entityManager.createQuery("SELECT a FROM User a", User.class).getResultList();
    }
}
