package tn.esprit.mohamedali.service;

import org.springframework.stereotype.Service;
import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.entity.Etudiant;
import tn.esprit.mohamedali.entity.Optionn;
import tn.esprit.mohamedali.repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IEtudiantServiceImp implements IEudiantService {

    private final EtudiantRepository etudiantRepository;

    public IEtudiantServiceImp(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant addAndAssignEtudiant(Etudiant e, Departement d) {
        e.setDepartement(d);
        etudiantRepository.save(e);
        return e;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(idEtudiant);
        return etudiant.orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
