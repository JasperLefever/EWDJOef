package domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Campus.findAll", query = "select c from Campus c"),
        @NamedQuery(name = "Campus.findByName", query = "select c from Campus c where c.campusNaam = :name")
})
public class Campus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int campusID;

    private String campusNaam;

    //@ManyToMany(mappedBy = "campussen", fetch = FetchType.EAGER)
    @ManyToMany(mappedBy = "campussen")
    private final Set<Docent> docenten = new HashSet<>();

    public static final long serialVersionUID = 1L;

    public Campus(String campusNaam) {
        this.campusNaam = campusNaam;
    }

    public Campus() {

    }

    public String getCampusNaam() {
        return this.campusNaam;
    }

    public void setCampusNaam(String campusNaam) {
        this.campusNaam = campusNaam;
    }

    public Set<Docent> getDocenten() {
        return Collections.unmodifiableSet(docenten);
    }

    public void addDocent(Docent docent) {
        docenten.add(docent);
    }

    public void removeDocent(Docent docent) {
        docenten.remove(docent);
    }

    @Override
    public String toString() {
        return String.format("%d %s", campusID, campusNaam);
    }

    /* Nooit primary key vergelijken met equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Campus campus = (Campus) o;

        return campusID == campus.campusID;
    }

    @Override
    public int hashCode() {
        return campusID;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Campus campus = (Campus) o;

        return Objects.equals(campusNaam, campus.campusNaam);
    }

    @Override
    public int hashCode() {
        return campusNaam != null ? campusNaam.hashCode() : 0;
    }
}
