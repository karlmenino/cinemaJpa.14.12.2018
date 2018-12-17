package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Component
public class PersonsDao {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public void save(Personne p){
        entityManager.merge(p);
    }

    public List<Personne> getAll(){
        Query query = entityManager.createQuery("Select p from Personne p");
        return query.getResultList();
    }

    public Personne getByAf( String id){
        Personne retVal = null;
        Query query = entityManager.createQuery("select p from Personne p where p.photoPath = :id");
        query.setParameter("id", id);
        List<Personne> persons = query.getResultList();
        if(!persons.isEmpty()){
            retVal = persons.get(0);
        }
        return retVal;
    }
}
