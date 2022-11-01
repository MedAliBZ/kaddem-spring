package tn.esprit.mohamedali.controller;


import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedali.entity.Departement;
import tn.esprit.mohamedali.service.IDepartementService;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {
    final private IDepartementService departementService;

    public DepartementController(IDepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping()
    List<Departement> retrieveAll() {
        return departementService.retrieveAllDepartements();
    }

    @PostMapping()
    Departement add(@RequestBody Departement ce){
        return departementService.addDepartement(ce);
    }

    @PatchMapping()
    Departement patch(@RequestBody Departement ce){
        return departementService.updateDepartement(ce);
    }

    @GetMapping("/{id}")
    Departement retrieveById(@PathVariable int id){
        return departementService.retrieveDepartement(id);
    }

    @GetMapping("/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable Integer idUniversite,@PathVariable Integer idDepartement){
        departementService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
}
