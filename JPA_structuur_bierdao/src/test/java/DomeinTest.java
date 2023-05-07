import domain.Bier;

import domain.DomeinController;
import domain.Winkel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import repository.BierDao;
import repository.GenericDao;

@ExtendWith(MockitoExtension.class)
public class DomeinTest {
	@Mock
    private GenericDao<Winkel> winkelRepo;
	@Mock
    private BierDao  bierRepo;
    @InjectMocks
    private DomeinController domein;
    
    @Test
    public void voegBierBijWinkel() {
       final String BIERNAAM = "Duvel", WINKELNAAM = "Station";

       Winkel eenWinkel = new Winkel(WINKELNAAM);   
       Bier eenBier = new Bier(BIERNAAM, "Blond", 8.5, 9.9, "Moortgat");

       Mockito.when(winkelRepo.findAll()).thenReturn(Arrays.asList(eenWinkel));
       Mockito.when(bierRepo.getBierByName(BIERNAAM)).thenReturn(eenBier);
       
       assertFalse(eenWinkel.getBierSet().contains(eenBier));
       domein.voegBierBijWinkel(BIERNAAM, WINKELNAAM);
       assertTrue(eenWinkel.getBierSet().contains(eenBier));
       Mockito.verify(winkelRepo).findAll();
       Mockito.verify(bierRepo).getBierByName(BIERNAAM); 
    }

}