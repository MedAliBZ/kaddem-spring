package tn.esprit.mohamedali.service;

import org.springframework.stereotype.Service;
import tn.esprit.mohamedali.entity.Universite;
import tn.esprit.mohamedali.repository.UniversiteRepository;

import java.util.List;

@Service
public class IUniversiteServiceImp implements IUniversiteService{
    final private UniversiteRepository universiteRepository;

    public IUniversiteServiceImp(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }


    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
}
