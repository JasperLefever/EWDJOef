package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.*;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Docent.docentenInTweeCampussen", 
	query = "SELECT d FROM Docent d WHERE :campusA MEMBER OF d.campussen AND :campusB MEMBER OF d.campussen") })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "docentNr")
public class Docent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Getter private int docentNr;

	@Getter private String voornaam;
	@Getter private String familienaam;
	@Setter @Getter private BigDecimal wedde;

	@ManyToMany
    private Set<Campus> campussen = new HashSet<>();
    
    @ManyToOne
	@Setter private Werkruimte werkruimte;

	public Docent(int docentNr, String voornaam, String familienaam, BigDecimal wedde) {
		this.docentNr = docentNr;
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.wedde = wedde;
	}

	public void opslag(BigDecimal bedrag) {
		wedde = wedde.add(bedrag);
	}

	public void addCampus(Campus campus) {
        campussen.add(campus);
    }

    public void removeCampus(Campus campus) {
        campussen.remove(campus);
    }

    public Set<Campus> getCampussen(){
    	return Collections.unmodifiableSet(campussen);
    }

    public String toString() {
    	return String.format("%s %s %.2f Campus: %s Werkruimte: %s%n", familienaam, voornaam, wedde, campussen, werkruimte);
    }

    /*
	protected Docent() {
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(docentNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docent other = (Docent) obj;
		return docentNr == other.docentNr;
	}
    */
    
}