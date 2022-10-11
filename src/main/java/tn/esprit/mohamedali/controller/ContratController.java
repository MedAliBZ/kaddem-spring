package tn.esprit.mohamedali.controller;


import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedali.entity.Contrat;
import tn.esprit.mohamedali.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {
    final private IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    @GetMapping("/")
    List<Contrat> retrieveAll() {
        return contratService.retrieveAllContrats();
    }

    @PostMapping("/")
    Contrat add(Contrat ce){
        return contratService.addContrat(ce);
    }

    @PatchMapping("/")
    Contrat patch(Contrat ce){
        return contratService.updateContrat(ce);
    }

    @GetMapping("/{id}")
    Contrat retrieveById(int id){
        return contratService.retrieveContrat(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(int id){
        contratService.removeContrat(id);
    }
}
