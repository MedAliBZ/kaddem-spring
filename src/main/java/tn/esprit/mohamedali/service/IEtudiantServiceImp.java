package tn.esprit.mohamedali.service;

import org.springframework.stereotype.Service;
import tn.esprit.mohamedali.entity.Contrat;
import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.entity.Equipe;
import tn.esprit.mohamedali.entity.Etudiant;
import tn.esprit.mohamedali.repository.ContratRepository;
import tn.esprit.mohamedali.repository.DepartementRepository;
import tn.esprit.mohamedali.repository.EquipeRepository;
import tn.esprit.mohamedali.repository.EtudiantRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IEtudiantServiceImp implements IEudiantService {

    private final EtudiantRepository etudiantRepository;
    private final DepartementRepository departementRepository;
    private final ContratRepository contratRepository;
    private final EquipeRepository equipeRepository;

    public IEtudiantServiceImp(EtudiantRepository etudiantRepository, DepartementRepository departementRepository, ContratRepository contratRepository, EquipeRepository equipeRepository) {
        this.etudiantRepository = etudiantRepository;
        this.departementRepository = departementRepository;
        this.contratRepository = contratRepository;
        this.equipeRepository = equipeRepository;
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
    public Etudiant assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Etudiant e = this.retrieveEtudiant(etudiantId);
        Departement d = this.departementRepository.findById(departementId).orElse(null);
        if(e != null && d != null) {
            e.setDepartement(d);
            etudiantRepository.save(e);
        }
        return e;
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Etudiant etudiant = this.addEtudiant(e);
        Contrat contrat = this.contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = this.equipeRepository.findById(idEquipe).orElse(null);
        if(equipe == null || contrat == null || etudiant == null)
            return null;
        else {
            contrat.setEtudiant(etudiant);
            contratRepository.save(contrat);
            if (etudiant.getEtudiantsEquipes() == null) {
                Set<Equipe> equipeSet = new HashSet<>();
                equipeSet.add(equipe);
                etudiant.setEtudiantsEquipes(equipeSet);
            }
            else
                etudiant.getEtudiantsEquipes().add(equipe);

            return etudiantRepository.save(etudiant);
        }
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
