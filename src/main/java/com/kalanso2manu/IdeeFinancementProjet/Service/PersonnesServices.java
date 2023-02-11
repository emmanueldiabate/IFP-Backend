package com.kalanso2manu.IdeeFinancementProjet.Service;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Personnes;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Utilisateurs;

import java.util.List;

public interface PersonnesServices {
    Personnes creer (Personnes personnes);
    List<Personnes> lire();


    Message updatePersonnesModifier(Long id, Personnes personnes);

    String supprimer (Long idpersonnes);
}
