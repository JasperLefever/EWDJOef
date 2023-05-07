package domein;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Onderhoudsbeurt.alleOnderhoudsbeurtenOpDatum", query = "SELECT o FROM Onderhoudsbeurt o WHERE :datum BETWEEN o.begindatum AND o.einddatum "),
})
public class Onderhoudsbeurt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate begindatum;
   
    private LocalDate einddatum;

    @ManyToOne
    private Vervoermiddel vervoermiddel;

    public Onderhoudsbeurt(LocalDate begindatum, LocalDate einddatum, Vervoermiddel vervoermiddel) {
        this.begindatum = begindatum;
        this.einddatum = einddatum;
        this.vervoermiddel = vervoermiddel;
    }

    public Onderhoudsbeurt() {

    }

    public LocalDate getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(LocalDate begindatum) {
        this.begindatum = begindatum;
    }

    public LocalDate getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(LocalDate einddatum) {
        this.einddatum = einddatum;
    }

    public Vervoermiddel getVervoermiddel() {
        return vervoermiddel;
    }

    public void setVervoermiddel(Vervoermiddel vervoermiddel) {
        this.vervoermiddel = vervoermiddel;
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

        Onderhoudsbeurt that = (Onderhoudsbeurt) o;

        if (!Objects.equals(begindatum, that.begindatum)) return false;
        if (!Objects.equals(einddatum, that.einddatum)) return false;
        return Objects.equals(vervoermiddel, that.vervoermiddel);
    }

    @Override
    public int hashCode() {
        int result = begindatum != null ? begindatum.hashCode() : 0;
        result = 31 * result + (einddatum != null ? einddatum.hashCode() : 0);
        result = 31 * result + (vervoermiddel != null ? vervoermiddel.hashCode() : 0);
        return result;
    }
}
