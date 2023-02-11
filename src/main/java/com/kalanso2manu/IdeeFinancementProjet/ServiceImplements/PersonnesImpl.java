package com.kalanso2manu.IdeeFinancementProjet.ServiceImplements;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Personnes;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Utilisateurs;
import com.kalanso2manu.IdeeFinancementProjet.Repository.PersonnesRepository;
import com.kalanso2manu.IdeeFinancementProjet.Service.PersonnesServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service

public class PersonnesImpl implements PersonnesServices {

    @Autowired
    private PersonnesRepository personnesRepository;

    @Override
    public Personnes creer(Personnes personnes) {
        personnes.setPhoto("http://127.0.0.1/IdeeFinancementProjet/images/utilisateur/Pere.JPG");
        return personnesRepository.save(personnes);
    }

    @Override
    public List<Personnes> lire() {

        return personnesRepository.findAll();
    }


    @Override

    public Message updatePersonnesModifier(Long id, Personnes personnes) {
        if (personnesRepository.findById(id) !=null)
        {

            Personnes update = personnesRepository.findById(id).get();
            update.setUsername(personnes.getUsername());
            update.setEmail(personnes.getEmail());
            update.setPassword(personnes.getPassword());
            update.setAdresse(personnes.getAdresse());
            update.setNomcomplet(personnes.getNomcomplet());
            update.setPhoto(personnes.getPhoto());
            update.setPseudo(personnes.getPseudo());
            personnesRepository.saveAndFlush(update); // enregistrement de l'objet mis à jour dans la base de données


            Message message = new Message("Personnes modifier avec succès!", true);
            return message;
        }
        Message message = new Message("Erreur cette personne n'existe pas!", false);
        return message;
    }


        /*public Message updateSecteurActiviter(SecteurActiviter secteurActiviter, Long idsecteur) {
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

             public Message updatePersonnes modifier(Personnes personnes, Long id) {
        if (personnesRepository.findAllById(id) !=null)
        {
            Personnes update = personnesRepository.findAllById(id).get();
            update.setUsername(personnesRepository.getUsername());
            update.setEmail(personnesRepository.getEmail());
            update.setPassword(personnesRepository.getPassword());
            update.setAdresse(personnesRepository.getAdresse());
            update.setNomcomplet(personnesRepository.getNomcomplet());
            update.setPhoto(personnesRepository.getPhoto());
            Message message = new Message("Personnes modifier avec succès!", true)
            return message;
        }
        Message message = new Message("Erreur ce secteur activiter n'existe pas!", false);
        return message;
    }
        } */


    @Override
    public String supprimer(Long idpersonnes) {

        personnesRepository.deleteById(idpersonnes);
        return "Personne supprimer avec succès!";

    }
}
