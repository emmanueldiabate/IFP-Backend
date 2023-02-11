package com.kalanso2manu.IdeeFinancementProjet.ServiceImplements;

import com.kalanso2manu.IdeeFinancementProjet.Message.EmailConstructor;
import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.AnnonceurExpert;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Projets;
import com.kalanso2manu.IdeeFinancementProjet.Repository.AnnonceurExpertRepository;
import com.kalanso2manu.IdeeFinancementProjet.Repository.ProjetsRepository;
import com.kalanso2manu.IdeeFinancementProjet.Service.AnnonceurExpertService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AnnonceurExpertImpl implements AnnonceurExpertService {

    @Autowired
    private AnnonceurExpertRepository annonceurExpertRepository;

    @Autowired
    private ProjetsRepository projetsRepository;

    @Autowired
    private EmailConstructor emailConstructor;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public AnnonceurExpert creer(AnnonceurExpert annonceurExpert) {
        annonceurExpert.setPhoto("http://127.0.0.1/IdeeFinancementProjet/images/utilisateur/Pere.JPG");
        return annonceurExpertRepository.save(annonceurExpert) ;
    }

    @Override
    public List<AnnonceurExpert> lire() {

        return annonceurExpertRepository.findAll();
    }

    @Override
    public Message updateAnnoncuerExpertModifier(Long id, AnnonceurExpert annonceurExpert) {


    //@Override

   // public AnnonceurExpert modifier(AnnonceurExpert annonceurExpert) {
       // annonceurExpertRepository.
       // return null;
       // public Message annoncuerExpert(Long id, AnnonceurExpert annonceurExpert) {
            if (annonceurExpertRepository.findById(id) !=null)
            {

                AnnonceurExpert update = annonceurExpertRepository.findById(id).get();
                update.setUsername(annonceurExpert.getUsername());
                update.setEmail(annonceurExpert.getEmail());
                update.setPassword(annonceurExpert.getPassword());
                update.setAdresse(annonceurExpert.getAdresse());
                update.setNomcomplet(annonceurExpert.getNomcomplet());
                update.setPhoto(annonceurExpert.getPhoto());
                update.setRoles(annonceurExpert.getRoles());
                update.setNomentreprise(annonceurExpert.getNomentreprise());
                update.setLocal(annonceurExpert.getLocal());
                update.setPiecesjointe(annonceurExpert.getPiecesjointe());
                annonceurExpertRepository.saveAndFlush(update); // enregistrement de l'objet mis à jour dans la base de données


                Message message = new Message("Annonceur-Expert modifier avec succès!", true);
                return message;
            }
            Message message = new Message("Erreur cet Annonceur-Expert n'existe pas!", false);
            return message;
        }


    @Override
    public String supprimer(Long id) {
         annonceurExpertRepository.deleteById(id);
         return "Annonceur-Expert Supprimer avec succès!";
    }

    @Override
    public String ValidationProject(Long AnnouncerExpertId, Long projetsId) {
        AnnonceurExpert expert = annonceurExpertRepository.findAnnonceurExpertById(AnnouncerExpertId);
        Projets projets = projetsRepository.findProjetsById(projetsId);
        projets.setStatut(true);
        mailSender.send(emailConstructor.constructpossibleFinancementProjet(expert,projets));
        return "le projet est encore de financement";
    }

    @Override
    public String AnnulerValidationProject(Long AnnouncerExpertId, Long projetsId) {
        AnnonceurExpert expert = annonceurExpertRepository.findAnnonceurExpertById(AnnouncerExpertId);
        Projets projets = projetsRepository.findProjetsById(projetsId);
        projets.setStatut(false);
        mailSender.send(emailConstructor.constructpossibleFinancementProjet(expert,projets));
        return "Financement du projet refusé";
    }


}
