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

    @GetMapping("/")
    List<Departement> retrieveAll() {
        return departementService.retrieveAllDepartements();
    }

    @PostMapping("/")
    Departement add(Departement ce){
        return departementService.addDepartement(ce);
    }

    @PatchMapping("/")
    Departement patch(Departement ce){
        return departementService.updateDepartement(ce);
    }

    @GetMapping("/{id}")
    Departement retrieveById(int id){
        return departementService.retrieveDepartement(id);
    }
}
