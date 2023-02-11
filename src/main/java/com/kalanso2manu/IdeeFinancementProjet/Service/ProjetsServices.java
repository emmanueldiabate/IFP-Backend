package com.kalanso2manu.IdeeFinancementProjet.Service;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Projets;

import java.util.List;

public interface ProjetsServices<auteur> {
    String creer(Projets projets);

    List< Projets> lire();

    Message  updateProjetModifier(Long id, Projets projets);

    String supprimer(Long id);

    List<Projets> searchProjects(String nom,String auteur);

}
