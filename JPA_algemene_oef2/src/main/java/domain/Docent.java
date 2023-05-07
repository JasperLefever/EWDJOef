package domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//JPA stappen:
//1. Maak een entity klasse
//2. Maak een default constructor
//3. Serialiseer de klasse
//4. Maak een primary key
//5. Maak een getter voor de primary key
//6. Maak een setter voor de primary key
//7. Maak een equals en hashcode methode

@Entity
@Table(name = "docenten")
@NamedQueries({
        @NamedQuery(name = "Docent.findAll", query = "select d from Docent d"),
        @NamedQuery(name = "Docent.docentenInTweeCampussen", query = "select d from Docent d where :campus1 member of d.campussen and :campus2 member of d.campussen"),
})
public class Docent implements Serializable {

    public static final long serialVersionUID = 1L;
    @Column(name = "personeelsnr")
    private int docentNr;
    private String voornaam;
    private String familienaam;
    private BigDecimal wedde;

    //@ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    private Set<Campus> campussen = new HashSet<>();

    @ManyToOne
    private Werkruimte werkruimte;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Docent(int docentNr, String voornaam, String familienaam, BigDecimal wedde) {
        this.docentNr = docentNr;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.wedde = wedde;
    }

    //Constructor voor JPA
    protected Docent() {

    }

    public int getDocentNr() {
        return docentNr;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public BigDecimal getWedde() {
        return wedde;
    }

    public void setWedde(BigDecimal wedde) {
        this.wedde = wedde;
    }

    public void opslag(BigDecimal bedrag) {
        wedde = wedde.add(bedrag);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s",
                docentNr, voornaam, familienaam, wedde, werkruimte);
    }

    public void addCampus(Campus campus) {
        campussen.add(campus);
    }

    public void removeCampus(Campus campus) {
        campussen.remove(campus);
    }

    public void setWerkruimte(Werkruimte w) {
        werkruimte = w;
    }

    public Set<Campus> getCampussen() {
        return Collections.unmodifiableSet(campussen);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Docent docent = (Docent) o;

        return docentNr == docent.docentNr;
    }

    @Override
    public int hashCode() {
        return docentNr;
    }
}
