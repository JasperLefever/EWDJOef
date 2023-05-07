package domain;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.persistence.EntityNotFoundException;
import repository.BierDao;
import repository.BierDaoJpa;
import repository.GenericDao;
import repository.GenericDaoJpa;

public class DomeinController {
    private List<Winkel> winkelList;
    private GenericDao<Winkel> winkelRepo;
    private BierDao  bierRepo;
    
    public DomeinController() {
    	this(false);
    }
    public DomeinController(boolean withInit) {
        if (withInit) {
            new PopulateDB().run();
        }
        setWinkelRepo(new GenericDaoJpa<>(Winkel.class));
        setBierRepo(new BierDaoJpa());
    }
    public void setWinkelRepo(GenericDao<Winkel> mock){
        winkelRepo = mock;
    }
    public void setBierRepo(BierDao mock){
        bierRepo = mock;
    }
 
    public List<String> geefWinkelList(){
        return getWinkelList().stream().map(Winkel::getNaam).collect(Collectors.toList());
    }
    
    private List<Winkel> getWinkelList(){
        if (winkelList==null){
            winkelList=winkelRepo.findAll();
        }
        return winkelList;
    }
    
    public void voegBierBijWinkel(String bierNaam, String winkelNaam) throws IllegalArgumentException {
        Optional<Winkel> winkel = getWinkelList().stream()
                .filter( w -> w.getNaam().equalsIgnoreCase(winkelNaam))
                .findFirst();
        if (!winkel.isPresent()) {
                throw new IllegalArgumentException("winkel " + winkelNaam + " komt niet voor");
        }
        Bier bier;
        try {
             bier = bierRepo.getBierByName(bierNaam);
        } catch(EntityNotFoundException ex) {
            throw new IllegalArgumentException("bier " + bierNaam + " komt niet voor");
        }
        GenericDaoJpa.startTransaction();
        winkel.get().addBier(bier);
        GenericDaoJpa.commitTransaction();
    }
    
    public List<String> geefBierLijst(Winkel winkel) {
        Set<Bier> bierSet = winkel.getBierSet();
        return bierSet.stream().map(Bier::toString).collect(Collectors.toList());
    }

    public void close() {
        GenericDaoJpa.closePersistency();
    }
    
}
