package tn.esprit.mohamedali.service;

import org.springframework.stereotype.Service;
import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.entity.Universite;
import tn.esprit.mohamedali.repository.DepartementRepository;
import tn.esprit.mohamedali.repository.UniversiteRepository;

import java.util.List;

@Service
public class IDepartementServiceImp implements IDepartementService {
    private final DepartementRepository departementRepository;
    private final UniversiteRepository universiteRepository;

    public IDepartementServiceImp(DepartementRepository departementRepository, UniversiteRepository universiteRepository) {
        this.departementRepository = departementRepository;
        this.universiteRepository = universiteRepository;
    }


    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public boolean assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Departement departement = this.retrieveDepartement(idDepartement);
        Universite universite = this.universiteRepository.findById(idUniversite).orElse(null);
        if (universite != null && departement != null) {
            universite.getDepartements().add(departement);
            this.universiteRepository.save(universite);
            return true;
        }
        return false;
    }
}
