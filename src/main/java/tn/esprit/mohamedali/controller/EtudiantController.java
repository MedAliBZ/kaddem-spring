package tn.esprit.mohamedali.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.entity.Etudiant;
import tn.esprit.mohamedali.service.IDepartementService;
import tn.esprit.mohamedali.service.IEudiantService;

import java.util.List;


@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    private final IEudiantService eudiantService;
    private final IDepartementService departementService;

    EtudiantController(IEudiantService eudiantService, IDepartementService departementService) {
        this.eudiantService = eudiantService;
        this.departementService = departementService;
    }

    @GetMapping("/")
    List<Etudiant> findall() {
        return this.eudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return this.eudiantService.addEtudiant(etudiant);
    }

    @PostMapping("/{depId}")
    Etudiant addAndAssign(@RequestBody Etudiant etudiant, @PathVariable int depId){
        Departement departement = departementService.retrieveDepartement(depId);
        if(departement != null)
            return this.eudiantService.addAndAssignEtudiant(etudiant,departement);
        else
            return null;
    }

    @PatchMapping("/")
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
}
