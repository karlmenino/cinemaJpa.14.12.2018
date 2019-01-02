package fr.laerce.cinema.dao;



import fr.laerce.cinema.model.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component

public interface RoleDao extends CrudRepository<Role, Long> {
}
