package fr.laerce.cinema.model;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="films")
public class Film {
    private long id;
    private String title;
    private Double rating;
    private String image_path;
    private String summary;
    private long film_director;
    public List<Role> role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 60)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "rating", nullable = true)
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    @Basic
    @Column(name = "image_path", nullable = true, length = 120)
    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }


    @Basic
    @Column(name = "image_path", nullable = true, length = 80)
    public String getSummary() {return summary;}
    public void setSummary(String summary) { this.summary = summary; }

    @Basic
    @Column(name = "film_director", nullable = true)
    public long getFilm_director() { return film_director; }
    public void setFilm_director(long film_director) {this.film_director = film_director; }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (id != film.id) return false;
        if (title != null ? !title.equals(film.title) : film.title != null) return false;
        if (rating != null ? !rating.equals(film.rating) : film.rating != null) return false;
        if (image_path != null ? !image_path.equals(film.image_path) : film.image_path != null) return false;
        if (summary != null ? !summary.equals(film.summary) : film.summary != null) return false;
        if (film_director != film.film_director) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getTitle (), getRating (), getImage_path (), getSummary (), getFilm_director (), getRole ());
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
