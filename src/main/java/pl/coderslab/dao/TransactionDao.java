package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.encje.Transaction;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransactionDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save(Transaction transaction){
        entityManager.persist(transaction);
    }
    public void update(Transaction transaction){
        entityManager.merge(transaction);
    }
    public void delete(Transaction publisher){
        entityManager.remove(entityManager.contains(publisher)?
                publisher:entityManager.merge(publisher));
    }
    public Transaction findById(long id){
        return entityManager.find(Transaction.class, id);
    }

    public List<Transaction> findAll() {
        return entityManager.createQuery("SELECT p FROM Publisher p", Transaction.class).getResultList();
    }
}
