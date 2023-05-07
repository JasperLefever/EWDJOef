package domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Winkel implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    private String naam;
    @OneToMany
    private Set<Bier> bierSet = new HashSet<>();

    public Winkel() {
    }

    public Winkel(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
    public void addBier(Bier bier){
        bierSet.add(bier);
    }
    
    public void removeBier(Bier bier){
        bierSet.remove(bier);
    }

    public Set<Bier> getBierSet() {
        return Collections.unmodifiableSet(bierSet);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.naam);
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
        final Winkel other = (Winkel) obj;
        return Objects.equals(this.naam, other.naam);
    }
    
}
