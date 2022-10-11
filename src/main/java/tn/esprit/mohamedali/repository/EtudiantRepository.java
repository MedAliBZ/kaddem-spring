package tn.esprit.mohamedali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.mohamedali.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
