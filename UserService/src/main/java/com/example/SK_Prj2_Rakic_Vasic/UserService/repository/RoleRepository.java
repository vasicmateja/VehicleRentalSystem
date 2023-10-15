package com.example.SK_Prj2_Rakic_Vasic.UserService.repository;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByRoleName(String name);

}
