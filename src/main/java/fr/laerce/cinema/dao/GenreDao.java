package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDao extends CrudRepository<Genre, Long> {}
