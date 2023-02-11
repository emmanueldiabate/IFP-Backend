package com.kalanso2manu.IdeeFinancementProjet.Repository;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.Personnes;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnesRepository extends JpaRepository<Personnes, Long> {
}
