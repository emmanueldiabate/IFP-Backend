package com.kalanso2manu.IdeeFinancementProjet.Controllers;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Personnes;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Utilisateurs;
import com.kalanso2manu.IdeeFinancementProjet.Service.PersonnesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/personnes")
public class PersonnesController {


    @Autowired
    private PersonnesServices personnesServices;

    @RequestMapping(value = "/create")
    public Personnes createPersonnes(@RequestBody Personnes personnes){

        return personnesServices.creer(personnes);
    }


    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Personnes> readPersonnes(){

        return personnesServices.lire();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Message updatePersonnes(@PathVariable("id") Long id, @RequestBody Personnes personnes){
        return personnesServices.updatePersonnesModifier(id,personnes);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deletePersonnes(@PathVariable Long id){

        return personnesServices.supprimer(id);
    }
   // @RequestMapping(value = "/delete/{idnotification}", method = RequestMethod.DELETE)
   // public String deleteNotification(@PathVariable Long idnotification){

      //  return notificationsServices.supprimer(idnotification);
    }


