package fr.laerce.cinema.model;

import javax.persistence.*;
import java.util.List;

//attention cette classe est un bean persistant(nom de classe = nom de table)
@Entity
@Table(name="persons")
public class Personne {
    private long id;
    private String nom;
    private String prenom;
    private Integer naissance;
    private String photoPath;
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
    @Column(name = "surname", nullable = false, length = 60)
    public String getNom() {
        return nom;
    }

    public void setNom(String surname) {
        this.nom = surname;
    }

    @Basic
    @Column(name = "givenname", nullable = true, length = 40)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String givenname) {
        this.prenom = givenname;
    }

    @Basic
    @Column(name = "birth_year", nullable = true)
    public Integer getNaissance() {
        return naissance;
    }

    public void setNaissance(Integer birthYear) {
        this.naissance = birthYear;
    }

    @Basic
    @Column(name = "image_path", nullable = true, length = 80)
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String imagePath) {
        this.photoPath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (id != personne.id) return false;
        if (nom != null ? !nom.equals(personne.nom) : personne.nom != null) return false;
        if (prenom != null ? !prenom.equals(personne.prenom) : personne.prenom != null) return false;
        if (naissance != null ? !naissance.equals(personne.naissance) : personne.naissance != null) return false;
        if (photoPath != null ? !photoPath.equals(personne.photoPath) : personne.photoPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (naissance != null ? naissance.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        return result;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
