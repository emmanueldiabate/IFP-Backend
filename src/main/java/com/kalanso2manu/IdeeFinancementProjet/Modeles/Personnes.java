package com.kalanso2manu.IdeeFinancementProjet.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Personnes extends Utilisateurs{

private String pseudo;
}
