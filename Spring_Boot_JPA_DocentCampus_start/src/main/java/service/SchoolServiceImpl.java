package service;

import domain.Campus;
import domain.Docent;
import domain.Werkruimte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CampusRepository;
import repository.DocentRepository;
import repository.WerkruimteRepository;

import java.util.List;
import java.util.Optional;

public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private DocentRepository docentRepository;
    @Autowired
    private CampusRepository campusRepository;
    @Autowired
    private WerkruimteRepository werkruimteRepository;

    public void changeWerkruimte(String lokaalCode,
                                 String campusNaam1, String campusNaam2) {

        Optional<Werkruimte> werkruimte = werkruimteRepository.findById(lokaalCode);

        Campus campusA = campusRepository.findByCampusNaam(campusNaam1);

        Campus campusB = campusRepository.findByCampusNaam(campusNaam2);

        if (campusA != null && campusB != null && werkruimte.isPresent()) {
            List<Docent> lijstDocenten = docentRepository.docentenInTweeCampussen(campusA, campusB);
            lijstDocenten.forEach(docent -> docent.setWerkruimte(werkruimte.get()));
        }

    }
}
