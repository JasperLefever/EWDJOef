package domein;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vervoermiddel implements TebetalenTaks, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private static final long serialVersionUID = 1L;
    private String nummerplaat;

    @OneToMany(mappedBy = "vervoermiddel", cascade = CascadeType.ALL)
    private List<Onderhoudsbeurt> onderhoudsbeurten = new ArrayList<>();

    public Vervoermiddel(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    public Vervoermiddel() {

    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }
    
    public List<Onderhoudsbeurt> getOnderhoudsbeurten() {
        return Collections.unmodifiableList(onderhoudsbeurten);
    }
    
    public void addOnderhoudsbeurt(Onderhoudsbeurt ob){
        onderhoudsbeurten.add(ob);
    }

    @Override
    public String toString() {
        return String.format("Vervoermiddel{nummerplaat=%s}%n", nummerplaat);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vervoermiddel that = (Vervoermiddel) o;

        return Objects.equals(nummerplaat, that.nummerplaat);
    }

    @Override
    public int hashCode() {
        return nummerplaat != null ? nummerplaat.hashCode() : 0;
    }
}
