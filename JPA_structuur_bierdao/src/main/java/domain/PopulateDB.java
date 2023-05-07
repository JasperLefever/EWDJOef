package domain;

import repository.BierDaoJpa;
import repository.GenericDaoJpa;

public class PopulateDB {
    public void run() {
        BierDaoJpa bierdao = new BierDaoJpa();
        BierDaoJpa.startTransaction();

        bierdao.insert(new Bier("WestVleteren_Blond", "blond", 5.0, 9.3, "Sint-Sixtusabdij van Westvleteren"));
        bierdao.insert(new Bier("Tripel_Kanunnik", "tripel", 8.2, 9.1, "Wilderen"));
        bierdao.insert(new Bier("Black_Albert", "tripel", 13.0, 9.0, "De Struise Brouwers"));
        bierdao.insert(new Bier("Rochefort_10", "donker", 11.0, 9.1, "Brasserie de l'Abbaye de Saint-Rémy"));
        bierdao.insert(new Bier("Alpaïde", "donker", 9.5, 9.0, "Nieuwhuys Hoegaarden"));
        bierdao.insert(new Bier("Cantillon_Geuze", "geuze", 5.0, 8.5, "Cantillon"));
        bierdao.insert(new Bier("Moinette_Blonde", "blond", 8.5, 8.5, "Dupont"));
        bierdao.insert(new Bier("Wilderen_Goud", "blond", 6.0, 8.4, "Wilderen"));                                                 
        bierdao.insert(new Bier("Tripel_Karmeliet", "tripel", 8.4, 8.3, "Bosteels")); 
        bierdao.insert(new Bier("Westmalle_Tripel", "tripel", 9.5, 8.2, "Abdij der trappisten van Westmalle"));

        GenericDaoJpa<Winkel> winkeldao = new GenericDaoJpa<>(Winkel.class);
        winkeldao.insert(new Winkel("Putteke"));
        winkeldao.insert(new Winkel("Op den hoek"));

        BierDaoJpa.commitTransaction();
    }
}
