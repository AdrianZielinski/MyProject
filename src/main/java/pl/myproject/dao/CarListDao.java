package pl.myproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.myproject.entity.Car;
import pl.myproject.entity.CarList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CarListDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Car> find() {
        return entityManager.createQuery("SELECT a FROM Car a", Car.class).getResultList();
    }




}
