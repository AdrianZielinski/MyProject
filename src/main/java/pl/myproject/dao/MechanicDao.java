package pl.myproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.myproject.entity.Mechanic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class MechanicDao {

    @PersistenceContext
    private EntityManager entityManager;
    public void save(Mechanic mechanic) {
        entityManager.persist(mechanic);
    }

    public void update(Mechanic mechanic) { entityManager.merge(mechanic); }

    public void delete(Mechanic mechanic) {
        entityManager.remove(entityManager.contains(mechanic) ? mechanic : entityManager.merge(mechanic));
    }

    public List<Mechanic> find() {
        Query query = entityManager.createQuery("SELECT b FROM Mechanic b");
        return query.getResultList();
    }

}
