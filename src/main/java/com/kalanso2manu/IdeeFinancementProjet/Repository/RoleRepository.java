package com.kalanso2manu.IdeeFinancementProjet.Repository;


import com.kalanso2manu.IdeeFinancementProjet.Modeles.ERole;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(ERole name);
}
