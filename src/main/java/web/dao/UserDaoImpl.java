package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }
    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(Long id, User user) {
        User personToBeUpdated = em.find(User.class, id);
        personToBeUpdated.setName(user.getName());
        personToBeUpdated.setPassword(user.getPassword());
        em.merge(personToBeUpdated);
    }
    @Override
    public void delete(Long id) {
        em.remove(em.find(User.class, id));
    }



}
