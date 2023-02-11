package com.kalanso2manu.IdeeFinancementProjet.Repository;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.SecteurActiviter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurActiviterRepository extends JpaRepository <SecteurActiviter, Long>{
    SecteurActiviter findByIdsecteur(Long idsecteur);
}
