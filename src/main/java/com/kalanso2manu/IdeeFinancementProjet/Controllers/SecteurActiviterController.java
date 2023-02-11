package com.kalanso2manu.IdeeFinancementProjet.Controllers;
import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.SecteurActiviter;
import com.kalanso2manu.IdeeFinancementProjet.Service.SecteurActiviterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/secteuractiviter")
public class SecteurActiviterController {

    @Autowired
    private final SecteurActiviterService secteurActiviterService;

    public SecteurActiviterController(SecteurActiviterService secteurActiviterService) {
        this.secteurActiviterService = secteurActiviterService;
    }

    @PostMapping("/create")
    public ResponseEntity<SecteurActiviter> createSecteurActiviter(@RequestBody SecteurActiviter secteurActiviter) {
        return new ResponseEntity<>(secteurActiviterService.createSecteurActiviter(secteurActiviter), HttpStatus.CREATED);
    }

    @PutMapping("/update/{idsecteur}")
    public Message updateSecteurActiviter(@RequestBody  SecteurActiviter secteurActiviter, @PathVariable Long idsecteur) {
       return secteurActiviterService.updateSecteurActiviter(secteurActiviter, idsecteur);

    }

    @GetMapping("/read")
    public List<SecteurActiviter> lire() {
        return secteurActiviterService.lire();
    }


    @DeleteMapping("/delete/{idsecteur}")
    public String deleteSecteurActiviter( @PathVariable Long idsecteur) {
        return secteurActiviterService.deleteSecteurActiviter(idsecteur);
}
    }
