package tn.esprit.mohamedali.controller;


import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamedali.entity.Universite;
import tn.esprit.mohamedali.service.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {
    final private IUniversiteService universiteService;

    public UniversiteController(IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @GetMapping()
    List<Universite> retrieveAll() {
        return universiteService.retrieveAllUniversites();
    }

    @PostMapping()
    Universite add(@RequestBody Universite ce){
        return universiteService.addUniversite(ce);
    }

    @PatchMapping()
    Universite patch(@RequestBody Universite ce){
        return universiteService.updateUniversite(ce);
    }

    @GetMapping("/{id}")
    Universite retrieveById(@PathVariable int id){
        return universiteService.retrieveUniversite(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable int id){
        universiteService.removeUniversite(id);
    }
}
