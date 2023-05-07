package domein;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "Auto.alleAutosZonderOnderhoudsbeurt", query = "SELECT a FROM Auto a WHERE SIZE(a.onderhoudsbeurten) = 0 "),
        @NamedQuery(name = "Auto.alleAutosMetOnderhoudsbeurt", query = "SELECT a FROM Auto a WHERE SIZE(a.onderhoudsbeurten) > 0 "),
})
public class Auto extends Vervoermiddel {
    private static final long serialVersionUID = 1L;

    public Auto(String nummerplaat) {
        super(nummerplaat);
    }

    public Auto() {

    }

    @Override
    public double geefVerkeersbelasting() {
        return 77.75;
        //volgens cilinderinhoud
    }
}
