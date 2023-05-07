package domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "campusNaam")
public class Campus implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int campusID;
	
	@Getter @Setter private String campusNaam;
	
	@ManyToMany(mappedBy = "campussen")
    private final  Set<Docent> docenten = new HashSet<>();
    
    public Campus(String campusNaam) {
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
    
    public String toString() {
    	return String.format("%s%n", campusNaam);
    }

    /*
	protected Campus() {
	}
	     
	@Override
	public int hashCode() {
		return Objects.hash(campusNaam);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campus other = (Campus) obj;
		return Objects.equals(campusNaam, other.campusNaam);
	}
    */
    
}
