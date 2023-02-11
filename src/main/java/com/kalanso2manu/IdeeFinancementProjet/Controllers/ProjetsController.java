package com.kalanso2manu.IdeeFinancementProjet.Controllers;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.AnnonceurExpert;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Personnes;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.SecteurActiviter;
import com.kalanso2manu.IdeeFinancementProjet.Repository.AnnonceurExpertRepository;
import com.kalanso2manu.IdeeFinancementProjet.Repository.ProjetsRepository;
import com.kalanso2manu.IdeeFinancementProjet.Repository.SecteurActiviterRepository;
import com.kalanso2manu.IdeeFinancementProjet.Service.ProjetsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;
import java.util.Optional;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.Projets;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Projets")

public class ProjetsController {
    @Autowired
    private ProjetsServices projetsServices;
    @Autowired
    ProjetsRepository projetsRepository;

    @Autowired
    AnnonceurExpertRepository annonceurExpertRepository;

    @Autowired
    SecteurActiviterRepository secteurActiviterRepository;

    @PostMapping(value = "/create/{annoceurexpertid}/{secteuractiviteid}")
    public String createProjet(@RequestBody Projets projets,@PathVariable("annoceurexpertid") Long ida, @PathVariable("secteuractiviteid") Long ids)
    {
        AnnonceurExpert annonceurExpert = annonceurExpertRepository.findById(ida).get();

        SecteurActiviter secteurActiviter = secteurActiviterRepository.findById(ids).get();

        projets.setAnnonceurExpert(annonceurExpert);

        projets.setSecteurActiviter(secteurActiviter);
        projetsServices.creer(projets);
        return "projets ajouter avec succes";
    }

    @GetMapping(value = "/read")
    public List<Projets> readProjet() {
        return projetsServices.lire();
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Message updateProjets(@PathVariable("id") Long id, @RequestBody Projets projets) {
        return projetsServices.updateProjetModifier(id, projets);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProjet(@PathVariable Long id) {
               projetsServices.supprimer(id);
        return "projets supprimer avec succes";
    }
    @GetMapping("/search")
    public List<Projets> searchProjects(@RequestParam String name, @RequestParam String auteur) {
        return projetsServices.searchProjects(name,auteur);
    }
}
