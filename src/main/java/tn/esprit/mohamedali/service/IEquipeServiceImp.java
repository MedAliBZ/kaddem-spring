package tn.esprit.mohamedali.service;

import org.springframework.stereotype.Service;
import tn.esprit.mohamedali.entity.Equipe;
import tn.esprit.mohamedali.repository.EquipeRepository;

import java.util.List;

@Service
public class IEquipeServiceImp implements IEquipeService{
    final private EquipeRepository equipeRepository;

    public IEquipeServiceImp(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }
}
