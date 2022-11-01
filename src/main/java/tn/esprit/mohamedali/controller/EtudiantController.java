package tn.esprit.mohamedali.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.entity.Etudiant;
import tn.esprit.mohamedali.service.IDepartementService;
import tn.esprit.mohamedali.service.IEudiantService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    private IEudiantService eudiantService;

    EtudiantController(IEudiantService eudiantService) {
        this.eudiantService = eudiantService;
    }

    @GetMapping()
    List<Etudiant> findall() {
        return this.eudiantService.retrieveAllEtudiants();
    }

    @PostMapping()
    Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return this.eudiantService.addEtudiant(etudiant);
    }

    @GetMapping("/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement (@PathVariable Integer etudiantId, @PathVariable Integer
            departementId){
            this.eudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }

    @PatchMapping()
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return this.eudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/{idEtudiant}")
    void getEtudiant(@PathVariable int idEtudiant){
        this.eudiantService.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/{idEtudiant}")
    void deleteEtudiant(@PathVariable int idEtudiant){
        this.eudiantService.removeEtudiant(idEtudiant);
    }
    
    @PostMapping("/{idContrat}/{idEquipe}")
    Etudiant addAndAssignEtudiantToEquipeAndContract(@PathVariable int idContrat, @PathVariable int idEquipe, @RequestBody Etudiant e){
        return this.eudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
}
