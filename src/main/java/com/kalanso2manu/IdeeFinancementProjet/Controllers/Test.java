package com.kalanso2manu.IdeeFinancementProjet.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/test")
public class Test {

    @GetMapping("/salutation")
    public String saluer(){
        return "Bonjour Emmanuel ";
    }
}
