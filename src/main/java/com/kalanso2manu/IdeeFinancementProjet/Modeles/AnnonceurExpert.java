package com.kalanso2manu.IdeeFinancementProjet.Modeles;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity

@AllArgsConstructor
@NoArgsConstructor
public class AnnonceurExpert extends Utilisateurs{
    private String nomentreprise;
    private String local;
    private String piecesjointe;
}
