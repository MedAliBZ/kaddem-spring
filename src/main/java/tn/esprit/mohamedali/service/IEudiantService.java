package tn.esprit.mohamedali.service;

import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.entity.Etudiant;
import tn.esprit.mohamedali.entity.Optionn;
import tn.esprit.mohamedali.repository.EtudiantRepository;

import java.util.List;

public interface IEudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant (Etudiant e);
    Etudiant addAndAssignEtudiant (Etudiant e, Departement d);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
}
