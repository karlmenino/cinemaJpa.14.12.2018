package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsDao extends CrudRepository<Personne, Long> {
    public Personne findByPhotoPath(String img);
}
