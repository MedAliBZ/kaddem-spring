package tn.esprit.mohamedali.service;

import tn.esprit.mohamedali.entity.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement(Departement d);
    Departement updateDepartement(Departement d);
    Departement retrieveDepartement(Integer idDepart);
}
