package com.kalanso2manu.IdeeFinancementProjet.ServiceImplements;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Projets;
import com.kalanso2manu.IdeeFinancementProjet.Repository.ProjetsRepository;
import com.kalanso2manu.IdeeFinancementProjet.Service.ProjetsServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProjetsImpl implements ProjetsServices {

    @Autowired
    private ProjetsRepository projetsRepository;

    @Override
    public String creer(Projets projets) {
        projetsRepository.save(projets);
        return "projet enregistrer avec succès";
    }

    @Override
    public List<Projets> lire() {

        return projetsRepository.findAll();
    }

    @Override
    public Message updateProjetModifier(Long id, Projets projets) {

        if (projetsRepository.findById(id) !=null)
        {
            Projets update = projetsRepository.findById(id).get();
            update.setNom(projets.getNom());
            update.setAuteur(projets.getAuteur());
            update.setDescription(projets.getDescription());
            update.setSecteurActiviter(projets.getSecteurActiviter());
            update.setAnnonceurExpert(projets.getAnnonceurExpert());
            update.setContenu(projets.getContenu());
            projetsRepository.saveAndFlush(update); // enregistrement de l'objet mis à jour dans la base de données


            Message message = new Message("Projets modifier avec succès!", true);
            return message;
        }
        Message message = new Message("Erreur ce projets n'existe pas!", false);
        return message;
    }

    @Override
    public String supprimer(Long id) {
         projetsRepository.deleteById(id);
        return "Annonceur-Expert Supprimer avec succès!";
    }

    @Override
    public List<Projets> searchProjects(String nom, String auteur) {
        return projetsRepository.findByNomAndAuteur(nom, auteur);
    }

    }



