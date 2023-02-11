package com.kalanso2manu.IdeeFinancementProjet.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Projets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Projets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;

    @Column(name = "statut")
    private boolean statut;
    private String auteur;
    private String description;
    private String contenu;

    @ManyToOne
    private SecteurActiviter secteurActiviter;
    @ManyToOne
    private AnnonceurExpert annonceurExpert;


}
