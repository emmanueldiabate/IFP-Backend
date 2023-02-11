package com.kalanso2manu.IdeeFinancementProjet.ServiceImplements;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Notification;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Utilisateurs;
import com.kalanso2manu.IdeeFinancementProjet.Repository.NotificationRepository;
import com.kalanso2manu.IdeeFinancementProjet.Service.NotificationsServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Setter

public class NotificationServicesImpl implements NotificationsServices {

    @Autowired
    NotificationRepository notificationRepository;


    @Override
    public Notification creer(Notification notification) {
        notification.setPhoto("http://127.0.0.1/IdeeFinancementProjet/images/utilisateur/Pere.JPG");
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> lire() {
        return notificationRepository.findAll();
    }

    @Override
    public Message updateNotificationmodifier(Long idnotification, Notification notification) {

            if (notificationRepository.findById(idnotification) !=null)
            {
                Notification update = notificationRepository.findById(idnotification).get();
                update.setLibelle(notification.getLibelle());
                update.setStatutfinance(notification.getStatutfinance());
                update.setPhoto(notification.getPhoto());
                notificationRepository.save(update); // enregistrement de l'objet mis à jour dans la base de données


                Message message = new Message("Notification modifier avec succès!", true);
                return message;
            }
            Message message = new Message("Erreur Notification n'existe pas!", false);
            return message;

    }

    @Override
    public String  supprimer(Long idnotification) {
           notificationRepository.deleteById(idnotification);
        return "Supprimer avec succès!";
    }


}
