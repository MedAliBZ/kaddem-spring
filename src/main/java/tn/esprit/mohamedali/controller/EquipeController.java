package tn.esprit.mohamedali.controller;


import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedali.entity.Equipe;
import tn.esprit.mohamedali.service.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
    final private IEquipeService equipeService;

    public EquipeController(IEquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping("/")
    List<Equipe> retrieveAll() {
        return equipeService.retrieveAllEquipes();
    }

    @PostMapping("/")
    Equipe add(Equipe ce){
        return equipeService.addEquipe(ce);
    }

    @PatchMapping("/")
    Equipe patch(Equipe ce){
        return equipeService.updateEquipe(ce);
    }

    @GetMapping("/{id}")
    Equipe retrieveById(int id){
        return equipeService.retrieveEquipe(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(int id){
        equipeService.removeEquipe(id);
    }
}
