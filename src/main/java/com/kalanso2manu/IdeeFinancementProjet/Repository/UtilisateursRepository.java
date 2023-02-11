package com.kalanso2manu.IdeeFinancementProjet.Repository;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long> {
  Optional<Utilisateurs> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

}
