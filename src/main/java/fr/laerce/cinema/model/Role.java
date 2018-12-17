package fr.laerce.cinema.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@Entity
//@Table(name="play")
public class Role {
        private long person_id;
        private long film_id;
        private Integer rank;
        private String name;

    @Id
    @Column(name = "person_id", nullable = false)
    public long getPerson_id() {return person_id; }
    public void setPerson_id(long person_id) {this.person_id = person_id;}

    @Id
    @Column(name = "film_id", nullable = false)
    public long getFilm_id() {return film_id;}
    public void setFilm_id(long film_id) {this.film_id = film_id;}

    @Basic
    @Column(name = "rank", nullable = false)
    public Integer getRank() {return rank;}
    public void setRank(Integer rank) {this.rank = rank; }

    @Basic
    @Column(name = "nome", nullable = false, length = 90)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getPerson_id () == role.getPerson_id () &&
                getFilm_id () == role.getFilm_id () &&
                Objects.equals (getRank (), role.getRank ()) &&
                Objects.equals (getName (), role.getName ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getPerson_id (), getFilm_id (), getRank (), getName ());
    }
}

