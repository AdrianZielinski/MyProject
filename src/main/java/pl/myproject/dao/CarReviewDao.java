package pl.myproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.myproject.entity.CarReview;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CarReviewDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(CarReview carReview) {
        entityManager.persist(carReview);
    }

    public void update(CarReview carReview) { entityManager.merge(carReview); }

    public void delete(CarReview carReview) {
        entityManager.remove(entityManager.contains(carReview) ? carReview : entityManager.merge(carReview));
    }

    public List<CarReview> find() {
        return entityManager.createQuery("SELECT a FROM CarReview a", CarReview.class).getResultList();
    }
}
