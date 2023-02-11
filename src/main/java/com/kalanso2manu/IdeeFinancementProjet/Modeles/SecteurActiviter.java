package com.kalanso2manu.IdeeFinancementProjet.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "secteuractiviter")
@AllArgsConstructor
@NoArgsConstructor
public class SecteurActiviter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsecteur;
    private String libellesecteur;
    private String descriptionsecteur;
}
