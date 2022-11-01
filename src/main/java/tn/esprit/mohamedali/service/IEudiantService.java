package tn.esprit.mohamedali.service;

import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.entity.Etudiant;
import tn.esprit.mohamedali.entity.Optionn;
import tn.esprit.mohamedali.repository.EtudiantRepository;

import java.util.List;

public interface IEudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant (Etudiant e);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
    Etudiant assignEtudiantToDepartement(Integer etudiantId, Integer departementId);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,
                                                     Integer idEquipe);
}
