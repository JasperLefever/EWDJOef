package com.springBoot.jpaDocentCampus_start;

import domain.Campus;
import domain.Docent;
import domain.Werkruimte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repository.CampusRepository;
import repository.DocentRepository;
import repository.WerkruimteRepository;

import java.math.BigDecimal;

@Component
public class InitDataConfig implements CommandLineRunner {

    @Autowired
    private DocentRepository docentRepository;
    @Autowired
    private CampusRepository campusRepository;
    @Autowired
    private WerkruimteRepository werkruimteRepository;


    @Override
    public void run(String... args) {

        Docent jan = new Docent(123, "Jan", "Baard", new BigDecimal(8000));
        Docent piet = new Docent(456, "Piet", "Baard", new BigDecimal(10000));
        Docent joris = new Docent(789, "Joris", "ZonderBaard", new BigDecimal(12000));

        Campus gent = new Campus("Gent");
        Campus aalst = new Campus("Aalst");

        Werkruimte zolder = new Werkruimte("SCH123", "zolder", 12, 6);
        Werkruimte kelder = new Werkruimte("SCH555", "kelder", 4, 4);
        Werkruimte dak = new Werkruimte("AA222", "dak", 10, 2);

        jan.addCampus(gent);
        piet.addCampus(gent);
        joris.addCampus(gent);

        jan.addCampus(aalst);
        joris.addCampus(aalst);

        jan.setWerkruimte(zolder);
        piet.setWerkruimte(zolder);
        joris.setWerkruimte(dak);

        werkruimteRepository.save(zolder);
        werkruimteRepository.save(kelder);
        werkruimteRepository.save(dak);

        campusRepository.save(gent);
        campusRepository.save(aalst);

        docentRepository.save(jan);
        docentRepository.save(piet);
        docentRepository.save(joris);

    }

}
