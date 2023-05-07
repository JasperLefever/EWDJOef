package domain;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "lokaalcode")
@AllArgsConstructor
public class Werkruimte implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String lokaalcode;
	private String naam;
	private int aantalStoelen;
	private int aantalComputers;

	@Override
	public String toString() {
		return String.format("%s %s %d %d", lokaalcode, naam, aantalStoelen, aantalComputers);
	}
	
	/*
	protected Werkruimte() {
	}
	
	public Werkruimte(String lokaalcode, String naam, int aantalStoelen, int aantalComputers) {
		super();
		this.lokaalcode = lokaalcode;
		this.naam = naam;
		this.aantalStoelen = aantalStoelen;
		this.aantalComputers = aantalComputers;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(lokaalcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Werkruimte other = (Werkruimte) obj;
		return Objects.equals(lokaalcode, other.lokaalcode);
	}
	*/
}
