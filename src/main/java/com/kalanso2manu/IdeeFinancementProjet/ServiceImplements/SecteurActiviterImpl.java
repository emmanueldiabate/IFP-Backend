package com.kalanso2manu.IdeeFinancementProjet.ServiceImplements;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.SecteurActiviter;
import com.kalanso2manu.IdeeFinancementProjet.Repository.SecteurActiviterRepository;
import com.kalanso2manu.IdeeFinancementProjet.Service.SecteurActiviterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecteurActiviterImpl implements SecteurActiviterService {
    @Autowired
    private SecteurActiviterRepository secteurActiviterRepository;


    @Override
    public SecteurActiviter createSecteurActiviter(SecteurActiviter secteurActiviter) {
        return  secteurActiviterRepository.save(secteurActiviter);

    }

    @Override
    public List<SecteurActiviter> lire(){
        return secteurActiviterRepository.findAll();
    }

    @Override
    public Message updateSecteurActiviter(SecteurActiviter secteurActiviter, Long idsecteur) {
        if (secteurActiviterRepository.findByIdsecteur(idsecteur) != null)
        {
            SecteurActiviter update = secteurActiviterRepository.findById(idsecteur).get();
            update.setDescriptionsecteur(secteurActiviter.getDescriptionsecteur());
            update.setLibellesecteur(secteurActiviter.getLibellesecteur());
            secteurActiviterRepository.save(update);
             Message message = new Message("Seceteur d'activiter modifier avec succès!", true);
             return message;
        }
        Message message = new Message("Erreur ce secteur activiter n'existe pas!", false);
        return message;
    }

    @Override
    public String deleteSecteurActiviter(Long idsecteur) {
         secteurActiviterRepository.deleteById(idsecteur);
        return "Secteur supprimer avec succès!";


    }
}
