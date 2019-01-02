package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component

public interface GenreDao extends CrudRepository<Genre, Long> {}
