package com.kalanso2manu.IdeeFinancementProjet.Service;

import com.kalanso2manu.IdeeFinancementProjet.Message.Message;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.AnnonceurExpert;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Personnes;

import java.util.List;

public interface AnnonceurExpertService {
    AnnonceurExpert creer(AnnonceurExpert annonceurExpert);
    List<AnnonceurExpert> lire();
  //  AnnonceurExpert modifier(AnnonceurExpert annonceurExpert);

    // public AnnonceurExpert modifier(AnnonceurExpert annonceurExpert) {
       // annonceurExpertRepository.
       // return null;
   // Message annoncuerExpert(Long id, AnnonceurExpert annonceurExpert);
    Message updateAnnoncuerExpertModifier(Long id, AnnonceurExpert annonceurExpert);

    String supprimer(Long id);

    String ValidationProject(Long AnnouncerExpertId, Long projetsId);
    String AnnulerValidationProject(Long AnnouncerExpertId, Long projetsId);
}
