package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Film;
import fr.laerce.cinema.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

public class FilmDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Film f){
        entityManager.persist(f);
    }

    public List<Film> getAll(){
        Query query = entityManager.createQuery("Select f from Film f");
        return query.getResultList();
    }

    public Film getById(BigInteger id){
        Film retVal = null;
        Query query = entityManager.createQuery("select f from Film f where f.id = :id");
        query.setParameter("id", id);
        List<Film> persons = query.getResultList();
        if(!persons.isEmpty()){
            retVal = persons.get(0);
        }
        return retVal;
    }
}

}
