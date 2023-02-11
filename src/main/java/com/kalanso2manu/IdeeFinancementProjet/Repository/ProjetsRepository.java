package com.kalanso2manu.IdeeFinancementProjet.Repository;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.Projets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetsRepository extends JpaRepository<Projets, Long> {
    Projets findProjetsById(Long id);

   // List<Projets> findByNameAndStatus(String nom, String statut);

    <contenu> List<Projets> findByNomAndAuteur(String nom, String auteur);

  /*  @Query("SELECT p FROM Projet p WHERE p.name LIKE %:name% AND p.auteur LIKE %:auteur%")
    List<Projet> findByNameContainingAndAuteurContaining(@Param("name") String name, @Param("auteur") String auteur);*/
}
