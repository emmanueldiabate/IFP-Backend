package com.kalanso2manu.IdeeFinancementProjet.Repository;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.AnnonceurExpert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceurExpertRepository extends JpaRepository<AnnonceurExpert, Long> {
    AnnonceurExpert findAnnonceurExpertById(Long id);
}
