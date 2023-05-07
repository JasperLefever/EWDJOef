package domain;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Bier.findByName",
                         query = "select b from Bier b where b.naam = :bierNaam")            
})
public class Bier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bierID;
    private String naam;
    private String soort;
    private String brouwerij;
    private double alcoholgehalte;
    private double beoordeling;

    public Bier() {
    }

    public Bier(String naam, String soort,  double alcoholgehalte, double beoordeling, String brouwerij) {
        this.naam = naam;
        this.soort = soort;
        this.alcoholgehalte = alcoholgehalte;
        this.beoordeling = beoordeling;
        this.brouwerij = brouwerij;
    }

    public int getBierID() {
        return bierID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public String getBrouwerij() {
        return brouwerij;
    }

    public void setBrouwerij(String brouwerij) {
        this.brouwerij = brouwerij;
    }

    public double getAlcoholgehalte() {
        return alcoholgehalte;
    }

    public void setAlcoholgehalte(double alcoholgehalte) {
        this.alcoholgehalte = alcoholgehalte;
    }

    public double getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(double beoordeling) {
        this.beoordeling = beoordeling;
    }

    @Override
    public String toString() {
        return "Bier{" + "bierID=" + bierID + ", naam=" + naam + ", soort=" + soort + ", brouwerij=" + brouwerij + ", alcoholgehalte=" + alcoholgehalte + ", beoordeling=" + beoordeling + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.naam);
        hash = 29 * hash + Objects.hashCode(this.soort);
        hash = 29 * hash + Objects.hashCode(this.brouwerij);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.alcoholgehalte) ^ (Double.doubleToLongBits(this.alcoholgehalte) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.beoordeling) ^ (Double.doubleToLongBits(this.beoordeling) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bier other = (Bier) obj;
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        if (!Objects.equals(this.soort, other.soort)) {
            return false;
        }
        if (!Objects.equals(this.brouwerij, other.brouwerij)) {
            return false;
        }
        if (Double.doubleToLongBits(this.alcoholgehalte) != Double.doubleToLongBits(other.alcoholgehalte)) {
            return false;
        }
        return Double.doubleToLongBits(this.beoordeling) == Double.doubleToLongBits(other.beoordeling);
    }

}
