package tn.esprit.mohamedali.service;

import org.springframework.stereotype.Service;
import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.repository.DepartementRepository;

import java.util.List;

@Service
public class IDepartementServiceImp implements IDepartementService {
    private final DepartementRepository departementRepository;

    public IDepartementServiceImp(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
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
}
