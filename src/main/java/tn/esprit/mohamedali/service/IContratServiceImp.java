package tn.esprit.mohamedali.service;

import org.springframework.stereotype.Service;
import tn.esprit.mohamedali.entity.Contrat;
import tn.esprit.mohamedali.repository.ContratRepository;

import java.util.List;

@Service
public class IContratServiceImp implements IContratService{

    private final ContratRepository contratRepository;

    public IContratServiceImp(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }
}
