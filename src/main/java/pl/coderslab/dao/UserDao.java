package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.encje.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save(User user){
        entityManager.persist(user);
    }
    public void update(User user){
        entityManager.merge(user);
    }
    public void delete(User user){
        entityManager.remove(entityManager.contains(user)?
                user:entityManager.merge(user));
    }
    public User findById(long id){
        return entityManager.find(User.class, id);
    }

    public List<User> findAll(){
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("select b from  User b", User.class);
        return query.getResultList();
    }
}