package pl.myproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.myproject.entity.Car;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CarDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Car car) {
        entityManager.persist(car);
    }

    public void update(Car car) { entityManager.merge(car); }

    public void delete(Car car) {
        entityManager.remove(entityManager.contains(car) ? car : entityManager.merge(car));
    }

    public List<Car> find() {
        Query query = entityManager.createQuery("SELECT b FROM Car b");
        return query.getResultList();
    }
}
