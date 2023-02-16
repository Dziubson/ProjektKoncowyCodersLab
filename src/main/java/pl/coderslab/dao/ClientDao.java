package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.encje.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save(Client client){
        entityManager.persist(client);
    }
    public void update(Client client){
        entityManager.merge(client);
    }
    public void delete(Client client){
        entityManager.remove(entityManager.contains(client)?
                client:entityManager.merge(client));
    }
    public Client findById(long id){
        return entityManager.find(Client.class, id);
    }
}
