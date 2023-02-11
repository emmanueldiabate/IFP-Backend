package com.kalanso2manu.IdeeFinancementProjet.Service;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Projets;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.SecteurActiviter;

import java.util.List;
import java.util.Optional;

public interface SecteurActiviterService {

    SecteurActiviter createSecteurActiviter(SecteurActiviter secteurActiviter);

    List<SecteurActiviter> lire();

    Message updateSecteurActiviter(SecteurActiviter secteurActiviter, Long idsecteur);

    String  deleteSecteurActiviter(Long id);
}
