package com.kalanso2manu.IdeeFinancementProjet.Controllers;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Notification;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Personnes;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Utilisateurs;
import com.kalanso2manu.IdeeFinancementProjet.Repository.NotificationRepository;
import com.kalanso2manu.IdeeFinancementProjet.Service.NotificationsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/notification")

public class NotificationController {

    @Autowired
    NotificationsServices notificationsServices;
    @RequestMapping(value = "/create")
    public Notification createNotification(@RequestBody Notification notification){

        return notificationsServices.creer(notification);
    }

    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Notification> readNotification(){

        return notificationsServices.lire();
    }
    @RequestMapping(value = "/update/{idnotification}", method = RequestMethod.PUT)
    public Message updateNotificatrion(@PathVariable("idnotification") Long idnotification, @RequestBody Notification notification){
        return notificationsServices.updateNotificationmodifier(idnotification, notification);
    }
    @RequestMapping(value = "/delete/{idnotification}", method = RequestMethod.DELETE)
    public String deleteNotification(@PathVariable Long idnotification){

        return notificationsServices.supprimer(idnotification);
    }
}
