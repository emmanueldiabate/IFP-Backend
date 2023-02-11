package com.kalanso2manu.IdeeFinancementProjet.Service;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Notification;

import java.util.List;

public interface NotificationsServices {

    Notification creer (Notification notification);
    List<Notification> lire();
    Message updateNotificationmodifier(Long idnotification, Notification notification );
    String supprimer (Long idnotification);


}
