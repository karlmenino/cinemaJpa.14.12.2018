package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Film;
import fr.laerce.cinema.model.Personne;
import fr.laerce.cinema.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Component
public class RoleDao {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public void save(Role r){
        entityManager.persist(r);
    }

    public List<Personne> getAll(){
        Query query = entityManager.createQuery("Select r from Role r");
        return query.getResultList();
    }

    public Role getById(BigInteger id,BigInteger idfilm){
        Role retVal = null;
        Query query = entityManager.createQuery("select r from Role r where r.person_id = :id and r.film_id= :idfilm");
        query.setParameter("id", id);
        query.setParameter("idfilm", idfilm);
        List<Role> persons = query.getResultList();
        if(!persons.isEmpty()){
            retVal = persons.get(0);
        }
        return retVal;
    }
}
