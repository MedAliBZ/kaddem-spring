package tn.esprit.mohamedali.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String prenomE;
    private String nomE;

    @Enumerated(EnumType.STRING)
    private Optionn optionn;

    @OneToOne
    private Contrat contrat;

    @ManyToOne
    private Departement departement;

    @ManyToMany
    Set<Equipe> etudiantsEquipes;


}
