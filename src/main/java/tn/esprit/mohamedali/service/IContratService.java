package tn.esprit.mohamedali.service;

import tn.esprit.mohamedali.entity.Contrat;

import java.util.List;

public interface IContratService {
    public List<Contrat> retrieveAllContrats();
    public Contrat addContrat(Contrat ce);
    public Contrat updateContrat(Contrat ce);
    public Contrat retrieveContrat(Integer idContrat);
    public void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);
}
