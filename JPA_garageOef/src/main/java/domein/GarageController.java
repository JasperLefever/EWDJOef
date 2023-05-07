package domein;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GarageController {

    private GarageBeheerder gb = new GarageBeheerder();

    public List<String> geefAutosZonderOnderhoudsbeurt() {
        List<Auto> li = gb.geefAutosZonderOnderhoudsbeurtJPA();
        return li.stream().map(a -> a.getNummerplaat()).collect(Collectors.toList());
    }

    public List<String> geefAutosMetOnderhoudsbeurt() {
        List<Auto> li = gb.geefAutosMetOnderhoudsbeurtJPA();
        return li.stream().map(a -> a.getNummerplaat()).collect(Collectors.toList());
    }

    public List<String> geefOnderhoudsbeurtenOpDatum(int jaar, int maand, int dag) {
        List<Onderhoudsbeurt> li = gb.geefOnderhoudsbeurtenOpDatumJPA(LocalDate.of(jaar, maand, dag));
        return li.stream().map(o -> o.getVervoermiddel().getNummerplaat()).collect(Collectors.toList());
    }

    public void close() {
        gb.closePersistentie();
    }

}
