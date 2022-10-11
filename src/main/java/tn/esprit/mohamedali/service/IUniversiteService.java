package tn.esprit.mohamedali.service;

import tn.esprit.mohamedali.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u); Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    void removeUniversite (Integer idUniversite);
}
