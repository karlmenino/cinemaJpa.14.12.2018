package fr.laerce.cinema;

import fr.laerce.cinema.dao.PersonsDao;
import fr.laerce.cinema.model.Personne;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run (CinemaApplication.class, args);
    }
}
