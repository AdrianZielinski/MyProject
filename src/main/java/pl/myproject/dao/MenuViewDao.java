package pl.myproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.myproject.entity.MenuView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class MenuViewDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MenuView> find() {
        Query query = entityManager.createQuery("SELECT b FROM MenuView b");
        return query.getResultList();
    }
}
