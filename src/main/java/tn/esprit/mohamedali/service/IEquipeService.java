package tn.esprit.mohamedali.service;

import tn.esprit.mohamedali.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe (Equipe e);
    Equipe retrieveEquipe (Integer idEquipe);
    void removeEquipe (Integer idEquipe);
}
