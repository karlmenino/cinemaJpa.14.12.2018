package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDao extends CrudRepository<Film, Long> {
}
