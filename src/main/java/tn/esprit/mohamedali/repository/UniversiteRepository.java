package tn.esprit.mohamedali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import tn.esprit.mohamedali.entity.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
}
