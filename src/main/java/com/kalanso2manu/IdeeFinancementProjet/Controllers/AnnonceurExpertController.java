package com.kalanso2manu.IdeeFinancementProjet.Controllers;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.AnnonceurExpert;
import com.kalanso2manu.IdeeFinancementProjet.Service.AnnonceurExpertService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/AnnonceurExpert")
public class AnnonceurExpertController {
    @Autowired
    private AnnonceurExpertService annonceurExpertService;

    @Autowired
    PasswordEncoder encoder;

    @RequestMapping(value = "/create")
    public AnnonceurExpert createAnnonceurExpert(@RequestBody AnnonceurExpert annonceurExpert) {
        annonceurExpert.setPassword(encoder.encode(annonceurExpert.getPassword()));

        return annonceurExpertService.creer(annonceurExpert);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<AnnonceurExpert> readAnnonceurExpert() {

        return annonceurExpertService.lire();
    }

   /* @RequestMapping(value = "/update", method = RequestMethod.PUT)
   *  @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Message updatePersonnes(@PathVariable("id") Long id, @RequestBody Personnes personnes){
        return personnesServices.updatePersonnesModifier(id,personnes);*/
    @PutMapping("/update/{id}")
    public Message updateAnnonceurExpert(@PathVariable("id") Long id , @RequestBody AnnonceurExpert annonceurExpert) {
        return annonceurExpertService.updateAnnoncuerExpertModifier(id, annonceurExpert);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteAnnonceurExpert(@PathVariable Long id) {
        return annonceurExpertService.supprimer(id);
    }
    @RequestMapping(value = "/valider/{idAnnouncerexpert}/{idProjet}", method = RequestMethod.POST)
    public String validerAFinancement(@PathVariable Long idAnnouncerexpert,@PathVariable Long idProjet) {
        return annonceurExpertService.ValidationProject(idAnnouncerexpert,idProjet);
    }
    @RequestMapping(value = "/annuler/{idAnnouncerexpert}/{idProjet}", method = RequestMethod.POST)
    public String refuserFinancement(@PathVariable Long idAnnouncerexpert,@PathVariable Long idProjet) {
        return annonceurExpertService.AnnulerValidationProject(idAnnouncerexpert,idProjet);
    }
}

